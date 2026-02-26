interface Job{
  void execute(string jsonData);
}
class JobServer
{
  Map<int,Lambda> lookup = new  Map<int,Lambda>();
  public JobServer(){
    lookup.add(1,()=>new BackupJob());
    lookup.add(2,()=>new RestoreJob());
    lookup.add(3,()=>new ArchiveJob());
    lookup.add(4,()=>new DataCleanupJob());
    ...
    lookup.add(35,()=>new CompressionJob());
  }
  
  //rest API
  //http://server/JobServer/execute?jobID=3&jsonData={}
  public void execute(int jobID,string jsonData)
  {
      Lambda createJob=lookup.get(jobID);
      Job  job=createJob();
      job.execute(jsonData);
  }
}

class BackupJob implements Job{
  void execute(string jsonData){...}
}
