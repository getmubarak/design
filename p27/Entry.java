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
                ...
                //format as word
                return word

            case "html":
                html = "";
                // format as HTML ...
                return html;
        }
    }
}
