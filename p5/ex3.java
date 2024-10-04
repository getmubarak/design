package problem5;

import java.util.HashMap;

//requirement
//===================
//object : { "Salary": 3500  , "Age" : 45 ,  "Department": "Sales" }
//rule : age < 28 or salary > 25000

public class Entry {
    public static void main(String[] args) 
    {
        object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
	      Rule r1 = new Rule("Age","<","28");
	      Rule r2 = new Rule("salary",">","25000");

	      ans1 = r1.Eval(object);
        ans2 = r2.Eval(object);
        ans3 = ans1 || ans2;
	      System.out.print(ans3);  
	        
    }
}
