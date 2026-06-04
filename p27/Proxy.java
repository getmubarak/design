for (Request incomingRequest : capturedTraffic) {
    // SMELL: Procedural Switch on Type/Mode
    switch (proxy.getMode()) {
        case RECORD:
            // High coupling: logic for recording, hashing, and storing all in one block
            String bodyHash = String.valueOf(incomingRequest.getBody().hashCode());
            Response realResponse = client.execute(incomingRequest);
            repository.save(incomingRequest, realResponse, bodyHash);
            break;

        case REPLAY:
            // Switch-case inside a loop often leads to "Shotgun Surgery"
            Stub mapping = repository.findExactMatch(incomingRequest);
            
            if (mapping != null) {
                // Manually handling "Vehicle-like" behaviors (Delays, Faults)
                if (mapping.hasDelay()) {
                    Thread.sleep(mapping.getDelayInterval());
                }
                if (mapping.shouldInjectError()) {
                    return Response.error(500);
                }
                return mapping.getStoredResponse();
            }
            break;

        case BYPASS:
            // Simple pass-through logic
            return client.execute(incomingRequest);
            
        case FAULT_INJECTION:
            // Rigidly defined fault logic
            proxy.applyGlobalRateLimit();
            proxy.terminateConnection();
            break;
    }
    
    // Post-processing smell: Mandatory cleanup/logging regardless of branch
    proxy.logTransaction(incomingRequest);
}
