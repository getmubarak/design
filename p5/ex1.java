package problem5;

import java.util.HashMap;

https://martinfowler.com/bliki/RulesEngine.html

//requirement
//===================
//object : { "Salary": 3500  , "Age" : 45 ,  "Department": "Sales" }
//rule : Department == 'purchase'

public class Entry {
    public static void main(String[] args) 
    {
        object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        Rule r1 = new Rule("Department","==","Purchase");
      	ans1 = r1.Eval(object);
        System.out.print(ans);  
    }
}
