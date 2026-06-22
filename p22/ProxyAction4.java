interface ProxyAction{
  execute();
  cleanupSockets();
}
class RecordAction implements ProxyAction{
  initializeStorage() {...}
  capture() {...}
  execute(){
    initializeStorage();
    capture();
  }
  cleanupSockets() {...}
}
...
for (ProxyAction action : actions) {
   action.execute();
   action.cleanupSockets();    
}
