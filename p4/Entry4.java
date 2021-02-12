package problem4;

interface Plugin{
  void doStart();
  void doStop();
  void doBranch();
  void doAction();
}
public interface Step {
 void call(Plugin p);
}
public class Start extends Step {
 Step next; 
 public Start(Step next) {this.next = next;}
 void call(Plugin p) { p.doStart(); }
}
public class Action extends Step{
 Step next;
 public Action(Step next) { this.next = next; }
 void call(Plugin p) { p.doStop(); }
}
public class Branch extends Step{
 Step left;
 Step right;
 
 public Branch(Step left,Step right) {
  this.left = left;
  this.right = right;
 }
 void call(Plugin p) { p.doBranch(); }
}
public class Stop extends Step{
  void call(Plugin p) { p.doStop(); }
}

class FlowPrinter implement Plugin{
  void doStart() {... }
  void doStop(){... }
  void doBranch(){... }
  void doAction(){... }
}
class FlowDAO implement Plugin{
  void doStart() {... }
  void doStop(){... }
  void doBranch(){... }
  void doAction(){... }
}
class FlowUI implement Plugin{
  void doStart() {... }
  void doStop(){... }
  void doBranch(){... }
  void doAction(){... }
}
public class Entry {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Step flow = factory.Load("flow1");
		FlowPrinter fp = new FlowPrinter();
		flow.call(fp);
	}
}
