package problem5;

import java.util.HashMap;

public class Entry {
    public static void main(String[] args) 
    {
        object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        //((Department == 'purchase') and (age < 28 or salary > 25000))
        #style 1 - simple
        Rule r1 = new StringEqual("Department","Purchase");
        Rule r2 = new LesserThan("Age","28");
        Rule r3 = new GreaterThan("salary","25000");
        Rule r4 = new OrRule(r2,r3);
        Rule rule = new AndRule(r1,r4);

        #style 2 - factory	    
        RuleEngine re = new RuleEngine();
        Rule r1 = re.stringEqual("Department","Purchase");
        Rule r2 = re.lessThan("Age","28");
        Rule r3 = re.greaterThan("salary","25000");
        Rule r4 = re.or(r2,r3);
        Rule rule = re.and(r1,r4);

        #style 2A - fluent
        Rule rule = re.and(re.stringEqual("Department","Purchase"),
                           re.or(re.lessThan("Age","28"),
                                 re.greaterThan("salary","25000"));

        #style 3 - builder
        RuleBuilder rb = new RuleBuilder();
        rb.addStringEqual("dept_rule","Department","Purchase");
        rb.addLessThan("age_rule","Age","28");
        rb.greaterThan("sal_rule","salary","25000");
        rb.or("person_rule","age_rule","sal_rule");
        rb.and("corp_rule","dept_rule","person_rule");    
        Rule rule = rb.getRule();

        #style 3A - chaining
        RuleBuilder rb = new RuleBuilder();
        rb.addStringEqual("r1","Department","Purchase")
                .addLessThan("r2","Age","28")
                .greaterThan("r3","salary","25000")
                .or("r4","r2","r3")
                .and("r1","r4"); 
        Rule rule = rb.getRule();

       

	    
        res = rule.eval(object);	   
        System.out.print(ans);  
   
    }
}
