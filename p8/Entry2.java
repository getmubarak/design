public class List {
	//collection
	public void add(int index ,Object item) {
		//logic to add item into collection
	}
	public void remove(int index ) {
		//logic to remove item from collection
	}
}
public class Queue extends List {
	public void enqueue(Object item) {
		super.add(0,item);
	}
	public void dequeue() {
		super.remove(0);
	}
}
public class Stack extends List {
	public void push(Object item) {
		super.add(length(),item);
	}
	public void pop() {
		super.remove(length());
	}
}
