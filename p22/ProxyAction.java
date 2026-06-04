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
            // CRASH! LSP VIOLATION: This subclass throws an exception because 
            // it cannot allow payload tweaking or standard initialization.
            action.initializeStorage(); 
            action.capture();
            break;
    }
    // Expected post-condition: Every action must clean up its socket
    action.cleanupSockets();    
}
