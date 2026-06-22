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
    if(type(action) == type(RecordAction))
        Execute((RecordAction)action);
    if(type(action) == type(ReplayAction))
        Execute((ReplayAction)action);
    if(type(action) == type(FaultInjectionAction))
        Execute((FaultInjectionAction)action);
    if(type(action) == type(SecurePassThruAction))
        Execute((SecurePassThruAction)action);
    action.cleanupSockets();    
}
