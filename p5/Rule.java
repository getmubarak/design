//r1 = new Rule("age", "20",">")
//r1.eval(obj)

class Rule
{
  String property;
  String value;
  char operator;
  
  public Rule(String property,String value,char operator)
  {
    this.property = property;
    this.value = value;
    this.operator = operator;
  }
  bool eval(Map<string,object> obj)
  {
    if(!obj.contains(property))
      return false;
    
    curValue = obj.get(property);
    switch(operator)
    {
      case '>':
        ...
        break;
    }
  }
}
