Network Record/Replay Proxy (Service Virtualization)
Problem Statement
You need to design a proxy that can record real API traffic and replay responses for deterministic tests,
with controllable delays and fault injection. The tool should:
# Record requests/responses with matching strategies (exact, header-aware, body hash).
# Replay based on rules (latency injection, error codes, rate limiting) for resilience testing.
# Support export/import of recordings (JSON/YAML) and versioning.
# Be testable: matching and replay engines run with in-memory adapters; no real networkrequired.
