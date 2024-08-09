public class Step {
}

public class Start extends Step {
	Step next;
	
	public Start(Step next) {
		this.next = next;
	}
}

public class Stop extends Step{

}

public class Action extends Step{
	Step next;
	
	public Action(Step next) {
		this.next = next;
	}
}

public class Branch extends Step{
	Step left;
	Step right;
	
	public Branch(Step left,Step right) {
		this.left = left;
		this.right = right;
	}
}




