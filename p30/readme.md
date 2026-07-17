# Network Record/Replay Proxy (Service Virtualization)

---

## Background

A record/replay proxy sits between an application and the external systems it depends on (payment gateways, shipping providers, fraud-check services), decoupling tests from live, unpredictable third parties.

- **Recording Phase**: traffic passes through to the real upstream service; the proxy fingerprints each request and persists the request→response pair.
- **Replay Phase**: the real service is disconnected; the proxy fingerprints incoming requests, looks up a match in its stub library, and plays back the stored response.
- **Hybrid Phase**: replay on a match, fall through to record on a miss.

This eliminates flaky CI runs from sandbox downtime, avoids hitting rate-limited/paid APIs during load tests, and lets developers run full suites offline.

You are building this as a **single-process library** — no distributed storage, no microservices, no plugin marketplace. All the complexity should live in your algorithms, data structures, and concurrency handling.

---

## Part 1 — Matching Engine (Core)

Design a `MatchStrategy` interface with at least these implementations:

| Strategy | Requirement |
|---|---|
| `ExactMatch` | HTTP verb + path, headers compared case-insensitively and order-independently |
| `HeaderAwareMatch` | Configurable ignore-list of header names, **including wildcard patterns** (e.g. `X-Request-*`) |
| `BodyHashMatch` | Recursive JSON canonicalization (sorted keys, normalized numbers, configurable field exclusion by JSON-path) hashed for comparison |
| `CompositeMatch` | Chains strategies; must resolve **ambiguous matches** deterministically when more than one recording qualifies |

**Hints:**
- For header order/case independence, don't compare raw header maps — normalize into a canonical form first (lowercase keys, sorted) and compare *that*.
- For wildcard header patterns, don't reach for your language's regex engine as a black box — write a small glob compiler: tokenize the pattern, build a matcher function. This is a good warm-up before the rule engine's condition parser in Part 5.
- For JSON canonicalization, think recursively: a canonicalizer for an object calls itself on each value; the tricky part is arrays — should `[1,2,3]` and `[3,2,1]` canonicalize the same way? Make this configurable, and write a test that would fail if you hardcoded either behavior.
- For ambiguous match resolution, resist "first in list wins." Score each candidate (e.g., number of matching non-ignored fields, recency) and define a deterministic tie-breaker for equal scores (e.g., insertion order) — write the tie-breaker test *before* the scoring logic, so you know what correct looks like.

---

## Part 2 — Recording Store (Core)

Two implementations behind one `RecordingStore` interface:

**In-memory store**
- Bounded size with **your own LRU eviction** (don't wrap a library's cache) — think hash map + doubly linked list for O(1) access and eviction.
- Lookup must not be a linear scan across all recordings. Index by a coarse key (method + path) and only run the full matcher within that bucket.

**File-based store**
- **Atomic writes**: write to a temp file, then rename — never write directly to the target path (a crash mid-write must never leave a corrupt file in place).
- **Graceful corruption handling** on load: one bad entry should not fail the whole load — skip it, log it, keep going.

**Hints:**
- For the LRU: the hard part isn't the map, it's keeping the linked list consistent on every `get` (which should also count as a "use," moving the entry to the front) — write a test that reads an old entry back and confirms it *doesn't* get evicted next.
- For atomic writes, check what rename actually guarantees on your OS/filesystem — same-directory rename is what makes this safe; renaming across filesystems isn't atomic.
- For corrupted entries, try parsing one recording at a time (not the whole file as one JSON blob) so a single bad record doesn't take down the rest — this affects your file format choice (JSON Lines vs one big JSON array).

---

## Part 3 — Sequential / Stateful Recordings (Core)

Some endpoints (e.g., polling `/job/status`) return **different responses on successive identical calls**. Model this with a `RecordingSequence`: an ordered list of responses tied to one match key, with a cursor that advances per call.

Requirements:
- Configurable exhaustion behavior when the cursor runs past the end: **repeat last**, **loop from start**, or **throw**.
- Thread-safe cursor advancement (two threads hitting the same sequence key must not skip or double-consume an entry).

**Hints:**
- Don't store the cursor position on the recording object itself if the store is shared across threads — use an atomic counter or a small lock scoped to that sequence key, not a global lock on the whole store.
- Write your test for exhaustion behavior *first* for all three modes — it's easy to implement "repeat last" and forget to test "loop," and vice versa.

---

## Part 4 — Fault Injection (Core, feeds into Part 5)

Faults are applied **after** a match is found, as a transformation on the response — never by mutating the stored recording.

- **Latency injection**: uses an injectable clock/scheduler so tests never actually sleep, but can assert the delay *would* apply.
- **Error injection**: replaces status/body based on a rule (see Part 5), using a seeded/injectable RNG — never call the language's default random function directly.
- **Rate limiting**: implement a real algorithm — sliding window or token bucket — not a request counter that resets naively.

**Hints:**
- Inject the clock and RNG as constructor/parameter dependencies from day one, even before you write a single fault rule — retrofitting determinism later is painful.
- For the rate limiter, think about what happens exactly at the window boundary (request N vs N+1) — write that boundary test before choosing between sliding window and token bucket, since the two behave differently there.

---

## Part 5 — Rule Engine for Fault Behavior (Core)

Instead of hardcoding fault logic as separate classes with scattered conditions, unify it behind a **rule engine**: a set of `(condition → action, priority)` rules evaluated against each request.

**Conditions** should be composable boolean expressions:
- Primitives: `pathMatches(pattern)`, `callCountGreaterThan(n)`, `headerEquals(name, value)`, `probability(p)`
- Combinators: `AND`, `OR`, `NOT`

**Actions**: `injectError(status, body)`, `addLatency(ms)`, `rateLimit(...)`

**Evaluation semantics** (must support both, configurable per rule set):
- **First-match-wins** (short-circuit on first satisfied rule, ordered by priority)
- **Accumulate-all** (multiple rules can stack — e.g., add latency *and* inject an error)

**Stateful conditions**: `callCountGreaterThan` needs a counter scoped per rule per session — thread-safe increments, shared correctly with the concurrency model from Part 7. `probability(p)` must consume the same injectable RNG as Part 4 — don't let the rule engine roll its own randomness.

**Hints:**
- Build the condition type as a small expression tree (`Condition` interface with `evaluate(context) -> bool`; `And`/`Or`/`Not` hold child conditions). This is the same shape as the header wildcard matcher from Part 1 — notice the reuse.
- Decide early: does evaluation return a single winning rule, or a list? This decision ripples through everything else — figure out accumulate-mode before you write first-match-mode, since accumulate is the more general case.
- For the stateful counter, ask yourself: does resetting happen per test session, per proxy lifetime, or never? Make it explicit, not accidental.

---

## Part 6 — Serialization & Versioning (Core)

- Recordings round-trip through JSON/YAML without losing fidelity: binary bodies (base64), non-UTF8 headers, null vs. missing fields distinguished.
- Large bodies (above a configurable size threshold) use a **streaming hash** rather than loading the full body into memory for `BodyHashMatch`.
- Schema evolves via a **chained migrator**: `v1→v2→v3` migrations compose automatically rather than one big if/else.

**Hints:**
- For the streaming hash, feed bytes into your hash function incrementally as they're read, rather than accumulating a buffer and hashing at the end — verify this produces the *same* hash as the non-streaming path for a small body (they must agree).
- For migrations, model each step as `canMigrate(fromVersion) -> bool` + `migrate(data) -> data`, then chain them by repeatedly applying whichever migrator matches the current version until none do. Test loading a v1 file and confirming it lands correctly at the current version.
