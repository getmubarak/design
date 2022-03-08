class SurveyData:
    public SurveyData(path,hidden){
      this.path="c:/application/data/" + path + ".dat";
      this.hidden=hidden;
    }
    static SurveyData RAW = new SurveyData("raw",True);
    static SurveyData cleanedUp = new SurveyData("cleanedUp",True);
    static SurveyData processed = new SurveyData("processed",True);
    static SurveyData publication = new SurveyData("publication",False);
}
path = SurveyData.RAW.getPath();
hidden = = SurveyData.RAW.getHidden();
