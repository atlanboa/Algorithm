import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SolutionWs20814 {
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
			Node[] tree = new Node[101];
			for(int i=0; i<101; i++) {
				tree[i] = new Node();
			}
			
			
			for(int i=1; i<n+1; i++) {
				
				st = new StringTokenizer(br.readLine());
				int verNum, left, right;
				String data;
				
				
				verNum = Integer.parseInt(st.nextToken());
				
				data = st.nextToken();
				
				if(st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
					tree[verNum].left = tree[left];
				}
				
				if(st.hasMoreTokens()) {

					right = Integer.parseInt(st.nextToken());					
					tree[verNum].right = tree[right];
					
					
				}tree[verNum].data = data;

				
			}
			
			System.out.print("#"+t+" ");
			inOrder(tree[1]);
			System.out.println();
			
			
		}
		
	}

	
	static void inOrder(Node node) {
		
		
		if(node == null) return;
		
		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
		

		
		
	}
	
}