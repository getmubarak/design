//r1 = new Rule("age", "20",">")
//r1.eval(obj)

class Rule
{
  String property; //dept
  String value;//sales
  char operator; //==
  
  public Rule(String property,String value,char operator)
  {
    this.property = property;
    this.value = value;
    this.operator = operator;
  }
  /*
    | age    | 30    |
    | salary | 2500. | 
    | dept   | purchase |
  */
  bool eval(Map<string,object> obj)
  {
    if(!obj.contains(property)) //dept
      return false;
    
    curValue = obj.get(property); //purchase
    switch(operator)
    {
      case '==':
        return value.equeals(curValue); sales == purchase
        break;
      case '>':
        ...
      case '<':
        ...
      case '!=':
        ...    
      case '<=':
        ...
       case '>=':
        ...
    }
  }
}
