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
        
        Rule r1 = new LesserRule("Age",28);
        Rule r2 = new GreaterRule("salary",25000);
        Rule r3 = new ORRule(r1,r2); <-- composition
      
        ans3 = r3.Eval(object);
        System.out.print(ans3);          
    }
}
