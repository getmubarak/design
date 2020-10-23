public class List {
	//collection
	public void add(Object item,int index ) {
		//logic to add item into collection
	}
	public void remove(int index ) {
		//logic to remove item from collection
	}
}

public class Queue extends List {
	public void enqueue(Object item) {
		//delegate to List methods
	}
	public void dequeue() {
		//delegate to List methods
	}
}

public class Stack extends List {
	public void push(Object item) {
		//delegate to List methods
	}
	public void pop() {
		//delegate to List methods
}
