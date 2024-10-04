interface Rule
{
  bool eval(HashMap<string,string> obj);
}

class GreaterRule implements Rule{
  string property;
  double value;
  public GreaterRule(string property,double value){
    this.property = property;
    this.value = value;
  }
  bool eval(HashMap<string,object> obj){
    cur_value = obj.get(property);
    if(double.parse(cur_value) > value)
      return true;
    else
      return false;
  }
}


class LesserRule implements Rule{
  string property;
  double value;
  public LesserRule(string property,double value){
    this.property = property;
    this.value = value;
  }
  bool eval(HashMap<string,object> obj){
    cur_value = obj.get(property);
    if(double.parse(cur_value) < value)
      return true;
    else
      return false;
  }
}
class EqualStringRule implements Rule{
  string property;
  string value;
  public EqualStringRule(string property,string value){
    this.property = property;
    this.value = value;
  }
  bool eval(HashMap<string,object> obj){
    cur_value = obj.get(property);
    if(cur_value.equals(value))
      return true;
    else
      return false;
  }
}

class AndRule implements Rule{
  Rule lhs;
  Rule rhs;
  public AndRule(Rule lhs,Rule rhs){
    this.lhs = lhs;
    this.rhs = rhs;
  }
  bool eval(HashMap<string,object> obj){
    return lhs.eval(obj) && rhs.eval(obj);
  }
}


