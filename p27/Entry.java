class StatisticsReport
{
    protected string document;

    public string getData(string format)
    {
        switch(format) {
            case "csv":
                lines = [];
                foreach (this->document as row) {
                    lines = implode(",", row);
                }
                return implode("\n", lines);

            case "word": 
                word="";
                
                //some logic for formating as word ...
                return word

            case "html":
                html = "";
                
                //  some logic for formating as HTML ...
                return html;
        }
    }
}
