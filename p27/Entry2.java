interface Formatter{
  void format(string document);
}
class CsvFormatter implements Formatter{
  
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
    protected string document;

    public string getData(Formatter formatter)
    {
       return formatter.format(document);
    }
}
