class SurveyData
{
    string path;
    bool hidden;
    
    public SurveyData(path,hidden){
      this.path="c:/application/data/" + path + ".dat";
      this.hidden=hidden;
    }
}
class SurveyDataType
{
    SurveyData RAW = new SurveyData("raw",True);
    SurveyData CLEANEDUP = new SurveyData("cleanedUp",True);
    SurveyData PROCESSED = new SurveyData("processed",True);
    SurveyData PUBLICATION = new SurveyData("publication",False);
};

void main(){
    SurveyDataType type = new SurveyDataType();
     path = type.RAW.getPath();
     hidden = type.RAW.getHidden();

}

