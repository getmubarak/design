import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

// ==========================================
// 1. CORE DOMAIN MODELS
// ==========================================
class Request {
    public final String method, path, body;
    public final Map<String, String> headers;
    
    public Request(String method, String path, Map<String, String> headers, String body) {
        this.method = method; this.path = path; 
        this.headers = headers != null ? headers : new HashMap<>(); this.body = body;
    }
}

class Response {
    public int statusCode;
    public String body;
    public final Map<String, String> headers = new HashMap<>();
    
    public Response(int statusCode, String body) { 
        this.statusCode = statusCode; this.body = body; 
    }
}

// ==========================================
// 2. MATCHING STRATEGY FAMILY
// ==========================================
interface MatchingStrategy { 
    String generateKey(Request request); 
    String getName(); 
}

class ExactPathStrategy implements MatchingStrategy {
    @Override public String generateKey(Request r) { return r.method + "|" + r.path; }
    @Override public String getName() { return "EXACT"; }
}

class BodyHashStrategy implements MatchingStrategy {
    @Override public String generateKey(Request r) { return r.method + "|" + r.path + "|" + (r.body != null ? r.body.hashCode() : 0); }
    @Override public String getName() { return "BODY_HASH"; }
}

class HeaderAwareStrategy implements MatchingStrategy {
    private final String targetHeader;
    public HeaderAwareStrategy(String targetHeader) { this.targetHeader = targetHeader; }
    @Override public String generateKey(Request r) { 
        return r.method + "|" + r.path + "|H:" + r.headers.getOrDefault(targetHeader, "MISSING"); 
    }
    @Override public String getName() { return "HEADER_AWARE:" + targetHeader; }
}

class RegexPathStrategy implements MatchingStrategy {
    private final Pattern pattern;
    private final String rawRegex;
    public RegexPathStrategy(String regex) { this.rawRegex = regex; this.pattern = Pattern.compile(regex); }
    @Override public String generateKey(Request r) {
        return r.method + "|" + (pattern.matcher(r.path).matches() ? "REGEX_MATCH" : "REGEX_MISMATCH");
    }
    @Override public String getName() { return "REGEX:" + rawRegex; }
}

// ==========================================
// 3. LATENCY STRATEGY FAMILY (Encapsulated Execution)
// ==========================================
interface LatencyStrategy { 
    void applyLatency(); 
    String serialize(); 
}

class NoDelay implements LatencyStrategy {
    @Override public void applyLatency() {} // No-Op execution
    @Override public String serialize() { return "NONE"; }
}

class FixedDelay implements LatencyStrategy {
    private final long delayMs;
    public FixedDelay(long delayMs) { this.delayMs = delayMs; }
    @Override public void applyLatency() {
        if (delayMs <= 0) return;
        try { Thread.sleep(delayMs); } 
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
    @Override public String serialize() { return "FIXED:" + delayMs; }
}

class JitterDelay implements LatencyStrategy {
    private final long min, max;
    public JitterDelay(long min, long max) { this.min = min; this.max = max; }
    @Override public void applyLatency() {
        long delay = ThreadLocalRandom.current().nextLong(min, max + 1);
        try { Thread.sleep(delay); } 
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
    @Override public String serialize() { return "JITTER:" + min + "," + max; }
}

class LinearBackoffDelay implements LatencyStrategy {
    private final long incrementMs, maxDelayMs;
    private int counter = 0;
    public LinearBackoffDelay(long incrementMs, long maxDelayMs) { this.incrementMs = incrementMs; this.maxDelayMs = maxDelayMs; }
    @Override synchronized public void applyLatency() {
        long delay = Math.min(incrementMs * (++counter), maxDelayMs);
        try { Thread.sleep(delay); } 
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
    @Override public String serialize() { return "LINEAR_BACKOFF:" + incrementMs + "," + maxDelayMs; }
}

// ==========================================
// 4. FAULT STRATEGY FAMILY
// ==========================================
interface FaultStrategy { 
    void inject(Response targetResponse); 
    String serialize(); 
}

class RateLimitFault implements FaultStrategy {
    @Override public void inject(Response res) { res.statusCode = 429; res.body = "{\"error\": \"Too Many Requests\"}"; }
    @Override public String serialize() { return "RATE_LIMIT"; }
}

class BadGatewayFault implements FaultStrategy {
    @Override public void inject(Response res) { res.statusCode = 502; res.body = "{\"error\": \"Bad Gateway\"}"; }
    @Override public String serialize() { return "BAD_GATEWAY"; }
}

class ServerErrorFault implements FaultStrategy {
    @Override public void inject(Response res) { res.statusCode = 500; res.body = "{\"error\": \"Internal Server Error\"}"; }
    @Override public String serialize() { return "SERVER_ERROR"; }
}

class NetworkDropFault implements FaultStrategy {
    @Override public void inject(Response res) { res.statusCode = 0; res.body = null; res.headers.clear(); }
    @Override public String serialize() { return "NETWORK_DROP"; }
}

// ==========================================
// 5. PROXY RULE & FLUENT BUILDER
// ==========================================
class ProxyRule {
    public final Response baseResponse;
    public final MatchingStrategy matchingStrategy;
    public LatencyStrategy latencyStrategy = new NoDelay();
    public FaultStrategy faultStrategy = null;

    public ProxyRule(Response baseResponse, MatchingStrategy matchingStrategy) { 
        this.baseResponse = baseResponse; this.matchingStrategy = matchingStrategy; 
    }

    public static class Builder {
        private Response response;
        private MatchingStrategy strategy = new ExactPathStrategy();
        private LatencyStrategy latency = new NoDelay();
        private FaultStrategy fault = null;

        public Builder response(int status, String body) { this.response = new Response(status, body); return this; }
        public Builder matchByBodyHash() { this.strategy = new BodyHashStrategy(); return this; }
        public Builder matchByHeader(String headerKey) { this.strategy = new HeaderAwareStrategy(headerKey); return this; }
        public Builder matchByRegex(String pathRegex) { this.strategy = new RegexPathStrategy(pathRegex); return this; }
        public Builder withFixedDelay(long delayMs) { this.latency = new FixedDelay(delayMs); return this; }
        public Builder withJitterDelay(long minMs, long maxMs) { this.latency = new JitterDelay(minMs, maxMs); return this; }
        public Builder withProgressiveDelay(long incrementMs, long maxMs) { this.latency = new LinearBackoffDelay(incrementMs, maxMs); return this; }
        public Builder introduceRateLimiting() { this.fault = new RateLimitFault(); return this; }
        public Builder introduceServerError() { this.fault = new ServerErrorFault(); return this; }
        public Builder introduceNetworkDrop() { this.fault = new NetworkDropFault(); return this; }

        public ProxyRule build() {
            if (response == null) throw new IllegalStateException("Base response missing.");
            ProxyRule rule = new ProxyRule(this.response, this.strategy);
            rule.latencyStrategy = this.latency;
            rule.faultStrategy = this.fault;
            return rule;
        }
    }
}

// ==========================================
// 6. PERSISTENCE LAYER (Marshaller Engine)
// ==========================================
class StubSerializer {
    public static String serialize(Map<String, ProxyRule> store) {
        StringBuilder out = new StringBuilder();
        for (Map.Entry<String, ProxyRule> entry : store.entrySet()) {
            ProxyRule rule = entry.getValue();
            out.append("KEY=").append(entry.getKey()).append("\n")
               .append("MATCH=").append(rule.matchingStrategy.getName()).append("\n")
               .append("STATUS=").append(rule.baseResponse.statusCode).append("\n")
               .append("BODY=").append(rule.baseResponse.body).append("\n")
               .append("LATENCY=").append(rule.latencyStrategy.serialize()).append("\n")
               .append("FAULT=").append(rule.faultStrategy != null ? rule.faultStrategy.serialize() : "NONE").append("\n")
               .append("===\n");
        }
        return out.toString();
    }

    public static Map<String, ProxyRule> deserialize(String data) {
        Map<String, ProxyRule> store = new ConcurrentHashMap<>();
        if (data == null || data.trim().isEmpty()) return store;

        for (String block : data.split("===\n")) {
            if (block.trim().isEmpty()) continue;
            Map<String, String> props = new HashMap<>();
            for (String line : block.split("\n")) {
                String[] kv = line.split("=", 2);
                if (kv.length == 2) props.put(kv[0], kv[1]);
            }

            // Remap Matcher Strategy
            String matchStr = props.get("MATCH");
            MatchingStrategy strat = new ExactPathStrategy();
            if ("BODY_HASH".equals(matchStr)) strat = new BodyHashStrategy();
            else if (matchStr.startsWith("HEADER_AWARE:")) strat = new HeaderAwareStrategy(matchStr.substring(13));
            else if (matchStr.startsWith("REGEX:")) strat = new RegexPathStrategy(matchStr.substring(6));

            ProxyRule rule = new ProxyRule(new Response(Integer.parseInt(props.get("STATUS")), props.get("BODY")), strat);

            // Remap Delay Strategy
            String latStr = props.get("LATENCY");
            if (latStr.startsWith("FIXED:")) rule.latencyStrategy = new FixedDelay(Long.parseLong(latStr.substring(6)));
            else if (latStr.startsWith("JITTER:")) {
                String[] r = latStr.substring(7).split(",");
                rule.latencyStrategy = new JitterDelay(Long.parseLong(r[0]), Long.parseLong(r[1]));
            } else if (latStr.startsWith("LINEAR_BACKOFF:")) {
                String[] r = latStr.substring(15).split(",");
                rule.latencyStrategy = new LinearBackoffDelay(Long.parseLong(r[0]), Long.parseLong(r[1]));
            }

            // Remap Fault Strategy
            String faultStr = props.get("FAULT");
            if ("RATE_LIMIT".equals(faultStr)) rule.faultStrategy = new RateLimitFault();
            else if ("BAD_GATEWAY".equals(faultStr)) rule.faultStrategy = new BadGatewayFault();
            else if ("SERVER_ERROR".equals(faultStr)) rule.faultStrategy = new ServerErrorFault();
            else if ("NETWORK_DROP".equals(faultStr)) rule.faultStrategy = new NetworkDropFault();

            store.put(props.get("KEY"), rule);
        }
        return store;
    }
}

// ==========================================
// 7. MAIN INTERCEPTION ENGINE
// ==========================================
class VirtualizationEngine {
    private Map<String, ProxyRule> stubStore = new ConcurrentHashMap<>();

    public void record(Request request, ProxyRule rule) {
        stubStore.put(rule.matchingStrategy.generateKey(request), rule);
    }

    public Response replay(Request request, MatchingStrategy resolutionStrategy) {
        ProxyRule rule = stubStore.get(resolutionStrategy.generateKey(request));
        if (rule == null) return new Response(404, "{\"error\": \"Stub mapping completely missing.\"}");

        // Strategy execution occurs natively outside core engine loop visibility
        rule.latencyStrategy.applyLatency();

        Response response = new Response(rule.baseResponse.statusCode, rule.baseResponse.body);
        if (rule.faultStrategy != null) {
            rule.faultStrategy.inject(response);
        }
        return response;
    }

    public String exportState() { return StubSerializer.serialize(this.stubStore); }
    public void loadState(String dump) { this.stubStore = StubSerializer.deserialize(dump); }
}

// ==========================================
// 8. EXECUTIVE RUNNER
// ==========================================
public class FullSystemVerification {
    public static void main(String[] args) {
        VirtualizationEngine primaryProxy = new VirtualizationEngine();

        // Target matching profiles
        Request requestA = new Request("GET", "/api/v1/user/account_883", null, "");
        Map<String, String> authMap = Collections.singletonMap("X-Tenant-Id", "Enterprise_Alpha");
        Request requestB = new Request("POST", "/api/v1/billing", authMap, "{}");

        // 1. Build complex strategy permutations using Fluent API
        ProxyRule regexServerCrashRule = new ProxyRule.Builder()
            .response(200, "{\"payload\": \"system_stable\"}")
            .matchByRegex("/api/v[0-9]/user/.*")
            .withFixedDelay(5)
            .introduceServerError()
            .build();

        ProxyRule headerRateLimitRule = new ProxyRule.Builder()
            .response(200, "{\"billing\": \"active\"}")
            .matchByHeader("X-Tenant-Id")
            .withJitterDelay(10, 20)
            .introduceRateLimiting()
            .build();

        primaryProxy.record(requestA, regexServerCrashRule);
        primaryProxy.record(requestB, headerRateLimitRule);

        // 2. Marshall Environment Configuration Snapshots
        String environmentSnapshot = primaryProxy.exportState();
        System.out.println("=== SERIALIZED SYSTEM CONFIGURATION ARCHIVE ===");
        System.out.print(environmentSnapshot);

        // 3. Unmarshall States inside a completely unique Isolated System Core
        VirtualizationEngine standaloneProxy = new VirtualizationEngine();
        standaloneProxy.loadState(environmentSnapshot);

        System.out.println("\n=== EXECUTING DETERMINISTIC PLATFORM EVALUATIONS ===");

        Response outputA = standaloneProxy.replay(requestA, new RegexPathStrategy("/api/v[0-9]/user/.*"));
        System.out.println("[Test 1 -> Regex Target Matcher]: Expected Status (500) -> Got: " + outputA.statusCode);

        Response outputB = standaloneProxy.replay(requestB, new HeaderAwareStrategy("X-Tenant-Id"));
        System.out.println("[Test 2 -> Header Tenant Matcher]: Expected Status (429) -> Got: " + outputB.statusCode);
    }
}
