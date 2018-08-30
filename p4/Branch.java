package problem4;

public class Branch extends Step{
	Step left;
	Step right;
	
	public Branch(Step left,Step right) {
		this.left = left;
		this.right = right;
	}
}
