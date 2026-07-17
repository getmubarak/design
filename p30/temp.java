RecordReplayProxy

RecordControl

  
class ReplayControl{
  RecordRepository recordRepository;

  Response OnRequest(request){
    int index = recordRepository.findFirstRequestMatch(request);
    return recordRepository.getResponse(index);
  }
}
class RecordRepository{
  List<Record> records;

  int findFirstRequestMatch(request){
    for(Record rec in records){
      if....
    }
  }
}
class Record{
  List<MatchingEngine> matchingEngines;
  Response response;
  
  bool checkMatch(request){
    for(MatchingEngine me in matchingEngines){
      if(....)
        return true;
      else
        return false;
    }
  }
  Response getResponse(){
    return response;
  }
}
  
interface MatchingEngine{
  bool match(request);
}
class ExactMatchEngine implements MatchingEngine{
  configuration 
  bool match(request){
    if(request.properties ... configuration)  
      return true;
    else
      return false;
  }
}
class HeaderAwareMatchEngine implements MatchingEngine{ }
class BodyHashMatchEngine implements MatchingEngine{{}

  
