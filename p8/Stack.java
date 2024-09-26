package problem8;

public class Stack {
	
	int top = 0;
	List li = new List();
	//collection
	public void push(Object item ) {
		li.add(item);
		top++;
		//logic to add item into collection
	}
	public void pop(int index ) {
		li.remove(--top);
		//logic to remove item from collection
	}
}
