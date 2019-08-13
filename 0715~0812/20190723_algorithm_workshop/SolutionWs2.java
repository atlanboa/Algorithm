import java.util.Scanner;
import java.util.Stack;

public class SolutionWs2 {
	static Stack<Character> stack = new Stack<Character>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt;
		char[] brachek;

		for(int t=1; t<=T; t++) {
			cnt = 0;

			brachek = sc.next().toCharArray();
			stack.push(brachek[0]);
			
			for(int i=1; i<brachek.length; i++) {
				if(brachek[i] == '(') {
					stack.push('(');
				}else {
					stack.pop();
					if(brachek[i-1] == ')') {
						cnt+= 1;
					}
					else {
						cnt += stack.size();
					}
				}
			}
			
			
			
			
			System.out.format("#%d %d\n",t,cnt);
		}
	}

}
