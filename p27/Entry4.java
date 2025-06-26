interface Formatter{
  void format(string document);
}
class CsvFormatter implements Formatter{
   StatisticsReport report;
   CsvFormatter(StatisticsReport report) {
     this.report = report;
   }
   void format(string document){
         lines = [];
         foreach (this->document as row) {
            lines = implode(",", row);
         }
         return implode("\n", lines);
   }
}
class JsonFormatter implements Formatter{
}
class HtmlFormatter implements Formatter{
}
class XmlmlFormatter implements Formatter{
}

class StatisticsReport
{
    ...
}
StatisticsReport report = new StatisticsReport();
report.create();
...
Formatter formatter = new CsvFormatter(report);
output = formatter.format();
