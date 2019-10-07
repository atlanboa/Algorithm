import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution1249_bfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;
	
	static int n;
	static int ans;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			dp = new int[n][n];
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				String line = br.readLine();
				for(int j=0; j<n; j++) {

					map[i][j] = line.charAt(j)-'0';
				}
				Arrays.fill(dp[i], Integer.MAX_VALUE);

			}
			
			ans = Integer.MAX_VALUE;
			bfs();
			System.out.println("#"+t+" "+dp[n-1][n-1]);

		}

	}
	private static void bfs() {
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));
		dp[0][0] = 0;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			
			for(int i=0; i<4; i++) {
				int nx, ny;
				nx = temp.x + dx[i];
				ny = temp.y + dy[i];
				
				if(0 <= nx && nx < n && 0 <= ny && ny < n
						   && dp[nx][ny] > dp[temp.x][temp.y]+map[nx][ny]) {
					dp[nx][ny] = dp[temp.x][temp.y] + map[nx][ny];
					queue.add(new Node(nx, ny));
				}
				
				
			}
			
			
			
		}
		
	}

	static class Node{
		int x;
		int y;
		public Node(int x , int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
