package problem5;

import java.util.HashMap;

public class Entry {
    public static void main(String[] args) 
    {
        Rule r = new Rule("Department","Purchase","==");
      
	object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        result = r.Eval(object)
        System.out.print(result);   
    }
}
