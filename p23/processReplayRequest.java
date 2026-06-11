public Response processReplayRequest(Request request) {
    ProxyConfig config = ProxyEngine.getConfig();
    
    // Level 1: Check if Replay Mode is active
    if (config.isReplayModeEnabled()) {
        
        // Level 2: Try to match the request using strategies (exact, header, body hash)
        MatchingEngine matcher = new MatchingEngine(config.getMatchingStrategy());
        RecordedPair match = matcher.findMatch(request);
        
        if (match != null) {
            
            // Level 3: Check for fault injection rules (e.g., simulated HTTP error codes)
            FaultRule fault = FaultEngine.getSimulatedFault(request);
            if (fault == null) {
                
                // Level 4: Check for latency injection rules
                LatencyRule latency = LatencyEngine.getSimulatedLatency(request);
                if (latency != null) {
                    TimeUtils.delay(latency.getDurationMs());
                }
                
                // Level 5: Check for rate limiting rules
                RateLimiter limiter = RateLimiterEngine.getLimiter(request);
                if (limiter.allowRequest()) {
                    
                    // The "Happy Path" buried deep inside the pyramid
                    return match.getResponse();
                    
                } else {
                    return Response.error(429, "Too Many Requests (Simulated)");
                }
            } else {
                return Response.error(fault.getStatusCode(), fault.getMessage());
            }
        } else {
            return Response.error(404, "No matching recorded request found");
        }
    } else {
        return Response.error(500, "Proxy is not in Replay Mode");
    }
}
