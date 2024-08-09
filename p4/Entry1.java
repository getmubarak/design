package problem4;

public class Entry {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Step flow1 = factory.Load("flow1");
		Print(flow1);
		
	}
	public static void Print(Step step)
	{
		if(step instanceof Start) {
			System.out.println("start");
			Start start = (Start) step;
			Print(start.next);
		}	
		if(step instanceof Action) {
			System.out.println("Action");
			Action action = (Action) step;
			Print(action.next);
		}
		if(step instanceof Branch) {
			System.out.println("Branch");
			Branch branch = (Branch) step;
			System.out.println("--> left");
			Print(branch.left);
			System.out.println("--> rigth");
			Print(branch.right);
		}	
		if(step instanceof Stop) {
			System.out.println("stop");
		
		}	
	}
	
}
