interface Job{
  void execute(string jsonData);
}
class JobServer
{
  Map<int,Job> lookup = new  Map<int,Job>();
  public JobServer(){
    lookup.add(1,new BackupJob());
    lookup.add(2,new RestoreJob());
    lookup.add(3,new ArchiveJob());
    lookup.add(4,new DataCleanupJob());
    ...
    lookup.add(35,new CompressionJob());
  }
  
  //rest API
  //http://server/JobServer/execute?jobID=3&jsonData={}
  public void execute(int jobID,string jsonData)
  {
      Job  job=lookup.get(jobID);
      job.execute(jsonData);
  }
}

class BackupJob implements Job{
  void execute(string jsonData){...}
}
class RestoreJob implements Job{
  void execute(string jsonData){...}
}
class ArchiveJob implements Job{
  void execute(string jsonData){...}
}
class DataCleanupJob implements Job{
  void execute(string jsonData){...}
}
class CompressionJob implements Job{
  void execute(string jsonData){...}
}
