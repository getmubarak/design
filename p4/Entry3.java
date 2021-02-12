package problem4;

static class Printer{
  void PrintStart(Step start) { ... }
  void PrintStop(Step stop) { ... }
  void PrintBranch(Step branch) { ... }
  void PrintAction(Step action) { ... }
}
public class Step {
 void print();
}

public class Start extends Step {
 Step next;
 
 public Start(Step next) {
  this.next = next;
 }
 void print() {
    Printer.printStart(this);
 }
}

public class Action extends Step{
 Step next;
 
 public Action(Step next) {
  this.next = next;
 }
 void print() {
  Printer.printAction(this);
 }
}

public class Branch extends Step{
 Step left;
 Step right;
 
 public Branch(Step left,Step right) {
  this.left = left;
  this.right = right;
 }
 void print() {
  Printer.printBranch(this);
 }
}
public class Stop extends Step{
 void print() {
  Printer.printSstop(this);
 }
}

public class Entry {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Step flow1 = factory.Load("flow1");
		flow1.print();
		
	}
}
