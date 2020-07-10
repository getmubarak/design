package problem4;

public class Step {
 void print();
}

public class Start extends Step {
 Step next;
 
 public Start(Step next) {
  this.next = next;
 }
 
 void print() {
  System.out.println(“start”);
  if (next != null) {
   next.print();
  }
 }
}

public class Action extends Step{
 Step next;
 
 public Action(Step next) {
  this.next = next;
 }
 
 void print() {
  System.out.println(“action”);
  if (next != null) {
   next.print();
  }
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
  System.out.println(“Branch”);
  System.out.println(“—> left”);
  if (left != null) {
   left.print();
  }
  System.out.println(“—> rigth”);
  if (right != null) {
   right.print();
  }
 }
}

public class Stop extends Step{
 void print() {
  System.out.println(“stop”);
 }
}

public class Entry {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Step flow1 = factory.Load("flow1");
		flow1.print();
		
	}
}
