void recordScenario(RecordReplayProxy proxy){
  NetworkObject networkobject = new NetworkObject();
  
  networkobject.request= new HeaderMatchRequest(url, header, payload); 
  # networkobject.request= new BodyHashMatchRequest(url, header, payload); 
  # networkobject.request= new UrlMatchRequest(url, header, payload);
  
  networkobject.response = new Response(header,payload);
  proxy.record(networkobject);
}
void replayScenario(RecordReplayProxy proxy){
  Request request = new Request(url, header, payload);
  request.Fault = new OutofMemoryFault("608","out of memory",",...");
  # request.Fault = new UrlNotFound("..","...",",...");
  request.RateLimit = ?;
  request.Latency = new JitterLatency(1000);
  Response resonse = proxy.replay(request);
}

void persistScenario(RecordReplayProxy proxy){
  RecordReplayProxyDao dao = new RecordReplayProxyDao();
  List<NetworkObject> networkObjects = proxy.getAllNetworkObject();
  dao.save(networkObjects);
}

void Main(){
  RecordReplayProxy proxy = new  RecordReplayProxy();
  recordScenario(proxy);
  replayScenario(proxy);
  persistScenario(proxy);




  List<Response> responses = proxy.fetchAllResponse();
  proxy.fetch(url);
}
