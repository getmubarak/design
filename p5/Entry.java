package problem5;

import java.util.HashMap;

public class Entry {
    public static void main(String[] args) 
    {
        Rule r1 = new Rule("Department","Purchase","==");
      
	object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        ans1 = r1.Eval(object);
        System.out.print(ans1);   
    }
}
