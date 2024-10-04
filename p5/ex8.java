package problem5;

import java.util.HashMap;

//requirement
//===================
//rule : ((Department == 'purchase') and (age < 28 or salary > 25000))
public class Entry {
    public static void main(){
        Rule r1 = new StringEqualRule("Department","Purchase");
        Rule r2 = new LesserRule("Age",28);
        Rule r3 = new GreaterRule("salary",25000);
        Rule r4 = new ORRule(r2,r3);
        Rule r5 = new AndRule(r1,r4);      
        XmlSerializer serializer = new XmlSerializer("rule.xml");
        serializer.serialize(r5);
    }
 /*** rule.xml
<AndRule>
    <EqualRule property="Department">"Purchase"</EqualRule>
    <OrRule>
        <LesserRule property="Age">28</LesserRule>
        <GreaterRule property="salary">25000</GreaterRule>
    </OrRule>
</AndRule>
**///  
    //object : { "Salary": 3500  , "Age" : 45 ,  "Department": "Sales" }
    public static void main(String[] args) 
    {
        object = new HashMap<>(); 
        object.put("Salary", 3500);
        object.put("Age", 45);
        object.put("Department", "Sales");
        
        XmlSerializer serializer = new XmlSerializer("rule.xml");
        Rule rule = serializer.Deserialize();
      
        ans = rule.Eval(object);
        System.out.print(ans);  
    }
 
}
