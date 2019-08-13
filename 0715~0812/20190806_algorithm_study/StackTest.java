
public class StackTest {

	public static void main(String[] args) {
		SStack stack = new SStack();
		
		stack.push('A');
		stack.push('B');
		stack.push('C');
		System.out.println(stack.size);
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
	}
	
}
