public class List {
	//collection
	public void add(Object item,int index ) {
		//logic to add item into collection
	}
	public void remove(int index ) {
		//logic to remove item from collection
	}
}
public class Queue {
	List ref;
  	public void enqueue(Object item) {
		ref.add(0,item);
	}
	public void dequeue() {
		ref.remove(0);
	}
}
public class Stack {
	List ref;

  	public void push(Object item) {
		ref.add(length(),item);
	}
	public void pop() {
		ref.remove(length());
	}
}
