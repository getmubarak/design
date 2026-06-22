void Execute(RecordAction action){
    action.initializeStorage();
    action.capture();
}
void Execute(ReplayAction action){
    action.evaluateMatchingRules();
    action.playMockResponse();
}
void Execute(FaultInjectionAction action){
    action.capture();
    action.injectLatency();
    action.tweakPayload();
}
void Execute(SecurePassThruAction action){
    action.setSSL(false);
    action.capture();
}
for (ProxyAction action : actions) {
    Execute(action);
    action.cleanupSockets();    
}
