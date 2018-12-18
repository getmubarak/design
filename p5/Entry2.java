package problem5;

import java.util.HashMap;

public class Entry {
	public static void main(String[] args) 
    {
        RuleEngine engine = new RuleEngine();
	       
	//String expression = "(salary > 2500 or age < 30) or (department = 'purchase')";
	Rule r1 = new Rule("salary","2500",1);
        Rule r2 = new Rule("age","30",2);
        Rule r3 = new Rule("department","purchase",3);
        
	RuleSet rs = new RuleSet();
	rs.add(r1);
	rs.add(r2);
	rs.add(r3);		
        engine.AddRule("rule1",rs);
		
     
        HashMap<String, Object> object = new HashMap<>(); 
        object.put("Salary", 2500);
        object.put("Age", 25);
        object.put("Department", "Purchase");
        boolean result = engine.Eval("rule1", object);        
        System.out.print(result);   
        
        object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        result = engine.Eval("rule1", object);        
        System.out.print(result);   
        
    }
}
