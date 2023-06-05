class StatisticsReport
{
    protected string document;

    public void createReport(){
        ... logic to create document
    }
        
    public string getDataCSV(string format){
                lines = [];
                foreach (this->document as row) {
                    lines = implode(",", row);
                }
                return implode("\n", lines);
    }
    public string getDataHtml(string format){
      ....
    }
    public string getDataJSON(string format){
      ....
    }
    public string getDataXML(string format){
       ...
    }
}
