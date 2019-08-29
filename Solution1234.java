import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution1234 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int t=1; t<=10;t++) {
			
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			char[] pass = st.nextToken().toCharArray();

			Stack<Character> stack = new Stack<>();
			
			for(int i=0; i<l; i++) {
				
				if(!stack.isEmpty() && stack.peek() == pass[i]) {
					stack.pop();
				}else {
					stack.push(pass[i]);
				}

			}
			
			String result = "";
			
			while(!stack.isEmpty()) {
				
				
				result = stack.pop() + result ;
			}
			
			System.out.println("#"+t+" "+result);
			
		}

	}

}
