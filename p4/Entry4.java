package problem4;

interface Plugin{
  void doStart(Start start);
  void doStop(Stop stop);
  void doBranch(Branch branch);
  void doAction(Action action);
}
public interface Step {
 void call(Plugin p);
}
public class Start extends Step {
 Step next; 
 public Start(Step next) {this.next = next;}
 void call(Plugin p) { p.doStart(this); }
}
public class Action extends Step{
 Step next;
 public Action(Step next) { this.next = next; }
 void call(Plugin p) { p.doAction(this); }
}
public class Branch extends Step{
 Step left;
 Step right;
 
 public Branch(Step left,Step right) {
  this.left = left;
  this.right = right;
 }
 void call(Plugin p) { p.doBranch(this); }
}

public class Stop extends Step{
  void call(Plugin p) { p.doStop(this); }
}

class FlowPrinter implement Plugin{
  void doStart(Start start) { Write("Start"); start.next.call(this); }
  void doStop(Stop stop){ Write("Stop"); }
  void doBranch(Branch branch){  Write("Branch"); 
			       branch.left.call(this);
			       branch.right.call(this);
			      }
  void doAction(Action action){ Write("Action"); action.next.call(this);  }
}
class FlowDAO implement Plugin{
  void doStart(Start start) {...}
  void doStop(Stop stop){... }
  void doBranch(Branch branch){... }
  void doAction(Action action){... }
}
class FlowUI implement Plugin{
  void doStart(Start start) { ...}
  void doStop(Stop stop){... }
  void doBranch(Branch branch){... }
  void doAction(Action action){... }
}
public class Entry {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Step flow = factory.Load("flow1");
		FlowPrinter fp = new FlowPrinter();
		flow.call(fp); //1
	}
}
