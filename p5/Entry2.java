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
        Rule r1 = new StringEqual("Department","Purchase");
	Rule r2 = new LesserThan("Age","28");
	Rule r3 = new GreaterThan("salary","25000");

	ans1 = r1.Eval(object);
        ans2 = r2.Eval(object);
        ans3 = r3.Eval(object);
	ans  = ans1 && ( ans2 || ans3); 
        System.out.print(ans);  
	        
    }
}
