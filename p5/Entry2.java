package problem5;

import java.util.HashMap;

public class Entry {
    public static void main(String[] args) 
    {
        Rule r1 = new Rule("Department","Purchase","==");
      	Rule r2 = new Rule("Salary","5000",">");
	
	object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        ans1 = r1.Eval(object);
	ans2 = r2.Eval(object);
        System.out.print(ans1 && ans2);   
    }
}
