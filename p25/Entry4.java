class SurveyData:
    public SurveyData(path,hidden){
      this.path="c:/application/data/" + path + ".dat";
      this.hidden=hidden;
    }
}
SurveyData RAW = new SurveyData("raw",True);
SurveyData CLEANEDUP = new SurveyData("cleanedUp",True);
SurveyData PROCESSED = new SurveyData("processed",True);
SurveyData PUBLICATION = new SurveyData("publication",False);

path = RAW.getPath();
hidden = RAW.getHidden();
