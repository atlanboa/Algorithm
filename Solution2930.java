import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2930 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Node> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			queue.clear();
			sb.append("#");
			sb.append(t);
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int a, b;
				a= Integer.parseInt(st.nextToken());
				
				if(a==1){
					b = Integer.parseInt(st.nextToken());
					queue.add(new Node(b));
					continue;
				}
					
				if(queue.isEmpty()) { 
					sb.append(" -1");
					continue;
				}
				sb.append(" ");
				sb.append(queue.poll().data);
				
				
				

				
			}
			sb.append("\n");
			
			
		}
		System.out.println(sb);
		
	}
	
	static class Node implements Comparable<Node>{
		
		int data;
		
		public Node(int data) {
			this.data = data;
		}

		@Override
		public int compareTo(Node n) {

			return n.data-data;
		}
	}
	

	
	

}
