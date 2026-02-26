//flag comes from outside world

class JobServer
{
  //rest API
  //http://server/JobServer/execute?jobID=3&jsonData={}
  public void execute(int jobID,string jsonData)
  {
       switch(jobID)
       {
         case 1:
           //Back up logic
           break;
         case 2:
            //Restore logic
           break;
         case 3:
            //Archive Logic
           break;
         case 4:
            //Data Cleanup logic
           break;
          ....
          case 35:
            //Compression logic
           break;
       }
  }
}
