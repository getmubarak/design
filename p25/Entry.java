class SurveyData{
    public SurveyData(){
      self.path="";
      self.hidden=False;
    }
    
    public void setSavePath(t){
        if t == 0:
            path = "c:/application/data/raw.dat";
            hidden = True;
        elif t == 1:
            path = "c:/application/data/cleanedUp.dat";
            hidden = True;
        elif t == 2:
            path = "c:/application/data/processed.dat";
            hidden = True;
        elif t == 3:
            path = "c:/application/data/publication.dat";
            hidden = False;
      }
}
