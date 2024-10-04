package problem5;

import java.util.HashMap;

//requirement
//===================
//object : { "Salary": 3500  , "Age" : 45 ,  "Department": "Sales" }
//rule : ((Department == 'purchase') and (age < 28 or salary > 25000))

public class Entry {
    public static void main(String[] args) 
    {
        object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        Rule r1 = new StringEqualRule("Department","Purchase");
        Rule r2 = new LesserRule("Age",28);
        Rule r3 = new GreaterRule("salary",25000);
        Rule r4 = new ORRule(r2,r3);
        Rule r5 = new AndRule(r1,r4);      
        
        ans = r5.Eval(object);
        System.out.print(ans);  
    }
}
