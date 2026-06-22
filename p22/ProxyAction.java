for (ProxyAction action : actions) {
    // The loop expects ALL actions to safely execute these steps based on their type
    switch (action.getType()) {
        case RECORD:
            action.initializeStorage();
            action.capture();
            break;
            
        case REPLAY:
            action.evaluateMatchingRules();
            action.playMockResponse();
            break;
            
        case FAULT_INJECTION:
            action.capture(); // Reusing capture to intercept
            action.injectLatency();
            action.tweakPayload();
            break;
            
        case SECURE_PASSTHROUGH:
            action.setSSL(false); 
            action.capture();
            break;
    }
    action.cleanupSockets();    
}
