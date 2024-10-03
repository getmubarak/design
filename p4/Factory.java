package problem4;

public class Step {

}
public class Action extends Step{
	Step next;
	
	public Action(Step next) {
		this.next = next;
	}
}
public class Start extends Step {
	Step next;
	
	public Start(Step next) {
		this.next = next;
	}
}
public class Stop extends Step{

}
public class Branch extends Step{
	Step left;
	Step right;
	
	public Branch(Step left,Step right) {
		this.left = left;
		this.right = right;
	}
}
public class Factory {
	public Step Load(String workflowName) {
		Stop stop = new Stop();
		Action action3 = new Action(stop);
		Action action2 = new Action(stop);
		Branch branch1 = new Branch(action2,action3);	
		Action action1 = new Action(branch1);
		Start start = new Start(action1);
		return start;
	}
}
