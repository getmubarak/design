package problem5;

import java.util.HashMap;

public class Entry {
    public static void main(String[] args) 
    {
        object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        //((Department == 'purchase') and (age < 28 or salary > 25000))
	RuleEngine re = new RuleEngine();
        Rule r1 = re.stringEqual("Department","Purchase");
	Rule r2 = re.lessThan("Age","28");
	Rule r3 = re.greaterThan("salary","25000");
	Rule r4 = re.or(r2,r3);
	Rule rule = re.and(r1,r4);
	   
	Rule rule = re.and(re.stringEqual("Department","Purchase"),
			   re.or(re.lessThan("Age","28"),
				 re.greaterThan("salary","25000")
			      );
   
	res = rule.eval(object);	   
        System.out.print(ans);  
	        
    }
}
