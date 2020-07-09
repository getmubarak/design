package problem5;

import java.util.HashMap;

public class Entry {
    public static void main(String[] args) 
    {
	Rule r1 = new Rule("Salary","5000",">");
	
	object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        result = Eval(r1,object)
        System.out.print(result);   
    }
}
