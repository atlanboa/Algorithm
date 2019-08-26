import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution7733 {
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] chk;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];
			for(int i=0; i<n;i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			int max = Integer.MIN_VALUE;
			int temp = -1;
			for(int i=0; i<=100; i++) {
				eat(i);
				copy();
				temp = findBlocks();
				if(max < temp) max = temp;
			}
			
			System.out.println("#"+t+" "+max);
		}

	}
	
	private static void copy() {
		chk = new boolean[map.length][map.length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				chk[i][j] = visited[i][j];
			}
		}
		
	}

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	private static int findBlocks() {
		int cnt = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				
				if(!visited[i][j] && !chk[i][j]) {
					bfs(i, j);
//					System.out.println(i+" "+j);
					cnt++;
				}
				
				
			}
		}
		
		
		
		
		return cnt;
	}
	private static void bfs(int x, int y) {
		
		LinkedList<Node> list = new LinkedList<>();
		chk[x][y] = true;
		list.add(new Node(x, y));
		while(!list.isEmpty()) {
			Node temp = list.poll();
			
			for(int i=0; i<4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(nx >=0 && ny >= 0 && nx < map.length && ny < map.length && !visited[nx][ny]
						&& !chk[nx][ny]) {
					chk[nx][ny] = true;
					list.add(new Node(nx, ny));
				}
					
			}
			
			
		}
		
		
		
	}
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void eat(int target) {
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				
				if(map[i][j]==target) {
					visited[i][j]=true;
				}
				
				
			}
		}
	}

}
