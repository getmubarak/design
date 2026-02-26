class JobServer
{
  Map<int,Lambda> lookup = new  Map<int,Lambda>();
  public JobServer(){
    DataReliability dr = new DataReliability();
    DataOptimization do = new DataOptimization();
    
    lookup.add(1,()=>dr.doBackupJob());
    lookup.add(2,()=>dr.doRestoreJob());
    lookup.add(3,()=>do.doArchiveJob());
    lookup.add(4,()=>do.doDataCleanupJob());
    ...
    lookup.add(35,()=>do.doCompressionJob());
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
class DataReliability{
  void doBackupJob(string jsonData){...}
  void doRestoreJob(string jsonData){...}
}
class DataOptimization{
  void doArchiveJob(string jsonData){...}
  void doDataCleanupJob(string jsonData){...}
  void doCompressionJob(string jsonData){...}
}
