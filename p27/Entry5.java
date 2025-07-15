

class StatisticsReport
{
    protected string document;

    public string getData(Lambda formatter)
    {
       return formatter(document);
    }
}

StatisticsReport report = new StatisticsReport();
...
LegacyFormatters formatter = new LegacyFormatters();

string data = report.getData((document)-> formatter.csvFormater(document));

class LegacyFormatters{
  string csvFormater(string document){
         lines = [];
         foreach (this->document as row) {
            lines = implode(",", row);
         }
         return implode("\n", lines);
   }
}
class HirarchicalFormatters
{
   string jsonFormater(string document){ ... }
   string xmlFormater(string document){ ... }
}
class PresentableFormatters
{
   string htmlFormater(string document){ ... }
   string pdfFormater(string document){ ... }
}
