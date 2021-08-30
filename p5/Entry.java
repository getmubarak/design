package problem5;

import java.util.HashMap;

public class Entry {
    public static void main(String[] args) 
    {
        object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
	//Department == 'purchase'
        Rule r1 = new Rule("Department","Purchase","==");
	ans1 = r1.Eval(object);
        System.out.print(ans1);  
	    
	    
        //((Department == 'purchase') and (age > 28 or salary > 25000))
    }
}
