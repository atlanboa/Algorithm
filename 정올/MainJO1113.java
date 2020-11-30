package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MainJO1113 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int M, N, m, n;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new int[M][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = 1000000;
				
			}
		}

		dp[0][0] = -1;
		

		
		int corner = bfs(m, n);
		
		
		
//		System.out.println(corner);
		System.out.println(dp[m][n]);
	}
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0,-1, 0};
	static int[][] dp;


	private static int bfs(int m, int n) {
		int cornerMin = Integer.MAX_VALUE;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, -1, -1));
		dp[0][0] = 0;
		
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
//			System.out.println(temp);

			
			for(int i=0; i<4; i++) {
				int nx, ny;
				nx = temp.x + dx[i];
				ny = temp.y	+ dy[i];
				
				if(temp.x == m && temp.y == n) {
					if(cornerMin > temp.corner) {
						cornerMin = temp.corner;
					}
					continue;
				}
				
				if(0 <= nx && nx < M && 0 <= ny && ny < N && map[nx][ny]==1) {
					Node next = new Node(nx, ny, temp.dir==i?temp.corner:temp.corner+1, i); 
					
					if(dp[nx][ny] > next.corner) {
						queue.add(next);
						dp[nx][ny] = next.corner;	
					}
					
					 
				}
				
			}
			
			
			
		}
		
		return cornerMin;
	}
	
	static class Node{
		int x, y, corner, dir;
		public Node(int x, int y, int corner, int dir) {
			this.x = x; this.y = y; this.corner = corner; this.dir = dir;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", corner=" + corner + ", dir=" + dir + "]";
		}
		
		
	}
}
