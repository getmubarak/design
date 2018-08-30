package problem5;

import java.util.HashMap;

public class Entry {
	public static void main(String[] args) 
    {
     
        HashMap<String, Object> object = new HashMap<>();
         
        object.put("Salary", 2500);
        object.put("Age", 25);
        object.put("Department", "Purchase");
        
        RuleEngine engine = new RuleEngine();
        
        
        boolean result = engine.Eval("rule1", object);
        
        System.out.print(result);   
    }
}
