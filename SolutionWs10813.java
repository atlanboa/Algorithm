import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SolutionWs10813 {
	static class Node{		
		String data;
		Node left;
		Node right;
		
		public Node() {
			data ="";
			left = null;
			right = null;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = 10;
		
		for(int t=1; t<=T; t++	) {
			int n = Integer.parseInt(br.readLine());
			Node[] tree = new Node[1001];
			for(int i=0; i<1001; i++) {
				tree[i] = new Node();
			}
			
			stack.clear();
			for(int i=1; i<n+1; i++) {
				
				st = new StringTokenizer(br.readLine());
				int verNum, left, right;
				String data;
				
				
				verNum = Integer.parseInt(st.nextToken());
				
				data = st.nextToken();
				
				if(st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
					right = Integer.parseInt(st.nextToken());
					
					tree[verNum].data = data;
					tree[verNum].left = tree[left];
					tree[verNum].right = tree[right];
					
					
				}else {
					tree[verNum].data = data;
				}
				
				
				

				
			}
			postOrder(tree[1]);
			
			System.out.format("#%d %.0f\n", t,  stack.pop());
			
		}
		
	}

	static Stack<Double> stack = new Stack<>();
	static void postOrder(Node node) {
		
		
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		
//		System.out.println("Data : "+node.data);
		
		if(node.data.equals("/") || node.data.equals("*") || node.data.equals("-")||node.data.equals("+")) {
			double num1 = stack.pop();
			double num2 = stack.pop();
			double result = 0; 
			switch(node.data) {
			case "/":
				result = num2/num1;
				break;
			case "*":
				result = num2*num1;
				break;
			case "+":
				result = num2+num1;
				break;
			case "-":
				result = num2-num1;
				break;
			}
			stack.push(result);
			
		}else {
			stack.push(Double.parseDouble(node.data));
		}
		
		
	}
	
}