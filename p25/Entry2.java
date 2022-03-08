class SurveyData{
    string path="";
    boolean hidden=False;
    
    abstract string getPath();
    abstract boolean getHidden();
}
class Raw extends SurveyData{
    string getPath() { return "c:/application/data/raw.dat"; }
    boolean getHidden() { return True; } 
}
class CleanedUp extends SurveyData{
    string getPath() { return "c:/application/data/cleanedUp.dat"; }
    boolean getHidden() { return True; } 
}
class Processed extends SurveyData{
    string getPath() { return "c:/application/data/processed.dat"; }
    boolean getHidden() { return True; } 
}
class Publication extends SurveyData{
    string getPath() { return "c:/application/data/publication.dat"; }
    boolean getHidden() { return False; } 
}
