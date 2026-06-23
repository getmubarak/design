public Response processReplayRequest(Request request) {
    ProxyConfig config = ProxyEngine.getConfig();
    config.checkReplayModeEnabled();
    MatchingEngine matcher = new MatchingEngine(config.getMatchingStrategy());
    RecordedPair match = matcher.findMatch(request);
    // Level 3: Check for fault injection rules (e.g., simulated HTTP error codes)
    FaultEngine.getSimulatedFault(request);
    // Level 4: Check for latency injection rules
    LatencyRule latency = LatencyEngine.getSimulatedLatency(request);
    TimeUtils.delay(latency.getDurationMs());
    // Level 5: Check for rate limiting rules
    RateLimiter limiter = RateLimiterEngine.getLimiter(request);
    limiter.checkAllowRequest();
    return match.getResponse();
}
