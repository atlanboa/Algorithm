package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SolutionWs0930 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T;t++) {
			int n, k;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			PriorityQueue<Node> queue = new PriorityQueue<>();
			for(int i=0; i<n; i++) {
				int v, c;
				st = new StringTokenizer(br.readLine());
				v = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				queue.add(new Node(v, c));
			}
			
//			while(!queue.isEmpty()) {
//				System.out.println(queue.poll());
//			}
			
			int[][] dp = new int[n+1][k+1];
			
			for(int i=1; i<n+1; i++) {
				Node temp = queue.poll();
				for(int j=1; j<k+1; j++) {
					if(temp.v > j)
						dp[i][j] = dp[i-1][j];
					else 
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-temp.v]+temp.c);
				}
			}
//			for(int i=0; i<dp.length; i++) {
//				System.out.println(Arrays.toString(dp[i]));
//			}
			
			bw.write("#"+t+" "+dp[n][k]+"\n");
			
		}
		bw.flush();
		bw.close();

	}

	static class Node implements Comparable<Node> {
		int v;
		int c;

		public Node(int v, int c) {
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			if (v > o.v) {
				return 1;
			} else {
				if (v == o.v) {
					return c > o.c ? 1 : -1;
				} else {
					return -1;
				}
			}

		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", c=" + c + "]";
		}
		
		
	}
}
