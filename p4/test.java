package problem4;

interface Plugin{
	void do(Start);
	void do(Stop);
	void do(Action);
	void do(Branch);
}
class Step{
	abstract void invoke(Plugin p);
}
class Start extends Step {
	void invoke(Plugin p) {	p.do(this); }
}
class Stop extends Step{
	void invoke(Plugin p) {	p.do(this); }
}
class Action extends Step {
	void invoke(Plugin p) {	p.do(this); }
}
class Branch extends Step {
	void invoke(Plugin p) {	p.do(this); }
}
//-----------------------------------
class PrintUtil implements Plugin
{
	void do(Start start){
		System.out.println("start");
		start.next.invoke(this);
	}
	void do(Stop){
		System.out.println("stop");
	}
	void do(Action action){
		System.out.println("Action");
		action.next.invoke(this);
	}
	void do(Branch branch){
		System.out.println("Branch");
		System.out.println("--> left");
		branch.left.invoke(this);
		System.out.println("--> rigth");
		branch.right.invoke(this);
	}
}
class TreeUtil implements Plugin
{
	void do(Start start){
		//logic
		start.next.invoke(this);
	}
	void do(Stop){
		//logic
	}
	void do(Action action){
		//logic
		action.next.invoke(this);
	}
	void do(Branch branch){
		//logic
		branch.left.invoke(this);
		//logic
		branch.right.invoke(this);
	}
}
public class Entry {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Step flow1 = factory.Load("flow1");
		PrintUtil printUtil = new PrintUtil();
		flow1.invoke(printUtil);
		TreeUtil treeUtil = new TreeUtil();
		flow1.invoke(treeUtil);
	}
	
}
