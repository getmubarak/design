package problem5;

import java.util.HashMap;

public class RuleEngine {
	HashMap<String,String> map = new HashMap<>();
	
	public void AddRule(String ruleId,String expression) {
		map.put(ruleId, expression);
	}
	public boolean Eval(String ruleId,HashMap<String, Object> Object)
	{
		String expression = map.get(ruleId);
		
		//..
		return true;
	}
}
