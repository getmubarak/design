abstract class ReplayRule {
    public abstract boolean evaluate(Request request);
    public abstract void apply(Response response);
    
    public void serializeRule() {
        // ... common serialization logic 1 (e.g., save rule ID and name)
        
        if (this instanceof LatencyRule) {
            // ... additional serialization logic specifically for LatencyRule (e.g., durationMs)
        }
        
        if (this instanceof FaultRule) {
            // ... additional serialization logic specifically for FaultRule (e.g., httpErrorCode)
        }
        
        if (this instanceof RateLimitRule) {
            // ... additional serialization logic specifically for RateLimitRule (e.g., requestsPerSecond)
        }
        
        // ... common serialization logic 2 (e.g., write to JSON/YAML exporter)
    }
}

class LatencyRule extends ReplayRule {
    public boolean evaluate(Request request) { /* logic 3 */ return true; }
    public void apply(Response response) { /* logic 4 */ }
}

class FaultRule extends ReplayRule {
    public boolean evaluate(Request request) { /* logic 5 */ return true; }
    public void apply(Response response) { /* logic 6 */ }
}

class RateLimitRule extends ReplayRule {
    public boolean evaluate(Request request) { /* logic 7 */ return true; }
    public void apply(Response response) { /* logic 8 */ }
}
