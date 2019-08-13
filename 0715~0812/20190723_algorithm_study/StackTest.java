import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<Character>();

		
//		SStack stack = new SStack();
		System.out.println(stack.isEmpty());
//		System.out.println(stack.isFull());
		
		
		stack.push('A');
		stack.push('B');
		stack.push('C');
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.pop());
//		System.out.println(stack.peek());
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//		stack.push('D');
//		stack.push('E');
//		stack.push('F');
//		stack.push('G');
//		stack.push('H');
//		
		
		
		
	}

}
