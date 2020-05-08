package problem5;

import java.util.HashMap;

public class Entry {
    public static void main(String[] args) 
    {
	Rule r1 = new Rule("Salary","5000",">");
        Rule r2 = new Rule("Age","50","<");
        Rule r3 = new Rule("Department","Purchase","=");
        RuleSet rs = new RuleSet();
	rs.add(r1);
	rs.add(r2);
	rs.add(r3);
	
	object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        result = Eval(rs,object)
        System.out.print(result);   
    }
}
