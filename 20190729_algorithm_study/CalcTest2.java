import java.util.Arrays;
import java.util.Stack;

public class CalcTest2{

	public static void main(String[] args) {
		String str = "(645+51*(2-8999)/240)";
		
		String postOrder = doPostOrderPro(str);
		System.out.println(postOrder);
		
		System.out.println(calculation(postOrder));
		
		

	}

	private static int calculation(String postOrder) {
		String[] srr = postOrder.split(" ");
		System.out.println(Arrays.toString(srr));
		Stack<Integer> stack = new Stack<Integer>();
		for(String ch: srr) {
			if(ch.equals("")) {
				continue;
			}
			else if(ch.equals("+") ||
					ch.equals("-") || ch.equals("*") || ch.equals("/")) {
				int temp = stack.pop();
				switch(ch) {
				
				case "-":
					stack.push(stack.pop()-temp);
					break;
				case "+":
					stack.push(stack.pop()+temp);
					break;
				case "*":
					stack.push(stack.pop()*temp);
					break;
				case "/":
					stack.push(stack.pop()/temp);
					break;
					
				}
				
				

				
			}else {
				stack.push(Integer.parseInt(ch));
			}
		}

		
		return stack.pop();
	}


	
	/*
	 * 1. ( 이면 push
	 * 2. 연산자? 자기보다 낮은 연산자가 나올때까지 pop
	 * 3. ) ( 만날때까지 pop
	 * 4. 숫자면 대기
	 */
	
	private static String doPostOrderPro(String str) {
		String result = "";
		char[] srr = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(char ch: srr) {
			if(ch=='(') {
				result += " ";
				stack.push(ch);
			}
			else if(ch==')') {
				while(true) {
					
					if(stack.peek() == '(') {
						stack.pop();
						break;
					}else {
						result += " "+stack.pop()+" ";
					}
				}
				
			}
			else if(ch >= '0' && ch <='9') {
				result += ch;
			}else {
				if(icp(ch) > isp(stack.peek())) {
					result += " ";
					stack.push(ch);
				}
				else {
					while(!stack.isEmpty() && icp(ch)<=isp(stack.peek())){
						result += " "+stack.pop()+" ";
					}
					
					stack.push(ch);
				}
			}
		}
		
		
		
		
		return result;
	}

	private static int icp(char charAt) {
	
	
	if(charAt == '(') return 3;
	else if(charAt == '*'||charAt == '/') return 2;
	else if(charAt == '+' || charAt=='-') return 1;
	else {
		return 0;
	}
	
	
}

private static int isp(char peek) {

	if(peek == '(') return 0;
	else if(peek == '+' || peek=='-') return 1;
	else if(peek == '*'||peek == '/') return 2;


	return 0;
}
}
