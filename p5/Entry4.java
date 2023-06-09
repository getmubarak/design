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
        Rule r4 = new OrRule(r2,r3);
        Rule r5 = new AndRule(r1,r4);
        
        //r5 ->r1
             ->r4->r2
                 ->r3
               
	ans = r5.Eval(object);
        System.out.print(ans);  
	        
    }
}
