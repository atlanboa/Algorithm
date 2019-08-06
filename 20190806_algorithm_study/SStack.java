
public class SStack {

	
	Node top = null;
	int size = 0;
	
	
	public char pop() {
		if(isEmpty()) {
			return '\u0000';
	
		}else {
			char temp = top.data;
			top = top.pre;
			
			
			return temp;
		}
	}
	
	
	public char peek() {
		if(isEmpty()) {
			return '\u0000';
		}else {
			return top.data;
		}
			
	}
	
	public void push(char data) {
		Node node = new Node();
		node.data = data;
		node.pre = top;
		top = node;
		size++;
	}
	
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		
		return size;
	}
	
	class Node{
		char data;
		Node pre;
	}
	
}
