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


        HashMap<string,string> object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        //Composite Pattern
        Rule r1 = new GreaterRule("Salary",5000.00);
	Rule r2 = new LesserRule("Age",50);
	Rule r3 = new EqualStringRule("Department","Purchase");
	Rule r4 = new AndRule(r1,r2);
	Rule r5 = new OrRule(r4,r3);    
	    
	res = r5.eval(object);	
	//"((Salary > 5000 && Age < 50) || (Department == 'Purchase'))"    
        System.out.print(res);   


/***
<AndRule>
    <EqualRule property="Department">"Purchase"</EqualRule>
    <OrRule>
        <LesserRule property="Age">28</LesserRule>
        <GreaterRule property="salary">25000</GreaterRule>
    </OrRule>
</AndRule>
**///
Rule r1 = new EqualRule("Department","Purchase");
Rule r2 = new LesserRule("Age",28);
Rule r3 = new GreaterRule("salary",25000);
Rule r4 = new OrRule(r2,r3);
Rule r5 = new AndRule(r1, r4);
