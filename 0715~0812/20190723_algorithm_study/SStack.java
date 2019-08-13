
public class SStack {

//데이터 저장 공간, 접근 위치
	char[] datas;
	int top=-1;
	int stackSize;
	
	public SStack(int size) {
		this.stackSize = size;
		this.datas = new char[this.stackSize];
//		this.top = -1;
	}
	
	public boolean isEmpty() {
		return top == -1? true : false;
	}
	
	public boolean isFull() {
		return top == stackSize-1? true : false;
	}
	
	public void push(char value) {
		if(isFull()) {
			System.out.println("Full");
			return;
		}
		else {
			top++;
			datas[top] = value;
		}
	}
	
	public char pop() {
		char ch = '\u0000';
		if(isEmpty()) { 
			System.out.println("Empty!");
			return ch;
		}else {
			ch = datas[top--];
		}
		
		return ch;
	}
	
	public char peek() {
		return datas[top];
	}
	
	public int size() {
		return top+1;
	}
}
