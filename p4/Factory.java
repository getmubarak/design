package problem4;

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
