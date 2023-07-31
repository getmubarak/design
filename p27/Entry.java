class StatisticsReportBuilder
{
    protected string reportDocument;

    public void createReport(){
        ... logic to create reportDocument
    }
        
    public string getReport(string format)
    {
        switch(format) {
            case "csv":
                lines = [];
                foreach (this->reportDocument as row) {
                    lines = implode(",", row);
                }
                return implode("\n", lines);

            case "json": 
                json="";
                
                //some logic for formating as json ...
                return word

            case "html":
                html = "";
                
                //  some logic for formating as HTML ...
                return html;
                
             case "xml":
                xml = "";
                
                //  some logic for formating as xml ...
                return xml;
        }
    }
}
