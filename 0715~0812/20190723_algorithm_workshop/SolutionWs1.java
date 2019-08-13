import java.util.Scanner;
import java.util.Stack;

//public class SolutionWs1 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		
//		for(int t=1; t<=T; t++) {
//			BigDecimal op1 = new BigDecimal(sc.next());
//			BigDecimal op2 = new BigDecimal(sc.next());
//			BigDecimal sum = op1.add(op2);
//			System.out.format("#%d %s\n",t, sum.toString());
//		}
//	}
//
//}

public class SolutionWs1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack1; 
		Stack<Character> stack2; 
		int T = sc.nextInt();
		char[] op1;
		char[] op2;
		for(int t=1; t<=T; t++) {
			
			stack1 = new Stack<Character>();
			stack2 = new Stack<Character>();
			
			
			
			op1 = sc.next().toCharArray();
			
			for(int i=0; i<op1.length; i++) {
				stack1.push(op1[i]);
			}
			
			
			op2 = sc.next().toCharArray();
			
			for(int i=0; i<op2.length; i++) {
				stack2.push(op2[i]);
			}
			
			String result = "";
			int up = 0;
			int num1, num2;
			int res;
			
			while(true) {
				if(stack1.size() == 0 && stack2.size() == 0 && up == 0) break;
				if(stack1.size() > 0) {
					num1 = Integer.parseInt(stack1.pop().toString());
				}
				else {
					num1 = 0;
				}
				
				if(stack2.size() > 0) {
					num2 = Integer.parseInt(stack2.pop().toString());
				}
				else {
					num2 = 0;
				}				
				res = num1 + num2 + up;
				up = 0;
				if(res > 9) {
					up = 1;
					result = Integer.toString(res-10) + result;
				}else {
					result =  Integer.toString(res) + result;
				}
				
				
				

			}
			
			System.out.format("#%d %s\n",t, result);
			
		}
	}

}

