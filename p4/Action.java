package problem4;

public class Action extends Step{
	Step next;
	
	public Action(Step next) {
		this.next = next;
	}
}
