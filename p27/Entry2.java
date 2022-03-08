interface Formatter{
  void format(string document);
}
class CsvFormatter implements Formatter{
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
