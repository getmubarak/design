//r1 = new StringEqualRule("Department","Purchase");
//r1.eval(obj)

interface Rule{
 bool eval(Map<string,object> obj);
}
class StringEqualRule implements Rule
{
  String property; //dept
  String value;//sales
  
  public StringEqualRule(String property,String value)
  {
    this.property = property;
    this.value = value;
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
    return value.equeals(curValue); //sales == purchase
  }
}
