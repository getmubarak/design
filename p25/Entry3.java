class SurveyData
{
    string path;
    bool hidden;
    
    public SurveyData(path,hidden){
      this.path="c:/application/data/" + path + ".dat";
      this.hidden=hidden;
    }
    static SurveyData RAW = new SurveyData("raw",True);
    static SurveyData CLEANEDUP = new SurveyData("cleanedUp",True);
    static SurveyData PROCESSED = new SurveyData("processed",True);
    static SurveyData PUBLICATION = new SurveyData("publication",False);
};
path = SurveyData.RAW.getPath();
hidden = SurveyData.RAW.getHidden();
