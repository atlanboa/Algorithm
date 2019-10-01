import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2636 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	static int[][] map;
	static int[][] rest;
	static int r, c;
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		rest = new int[r][c];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				
			}
		}
		int time = 0;
		int cnt = 0;
		while(isPromising()) {
			bfs(++time);	
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				
				if(rest[i][j]==time) {
					cnt++;
				}
				
				
			}
		}
		
		System.out.println(time);
		System.out.println(cnt);
//		for(int i=0; i<r; i++) {
//			System.out.println(Arrays.toString(rest[i]));
//		}
//		System.out.println();
//		for(int i=0; i<r; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
	 
	}
	
	private static boolean isPromising() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				
				if(map[i][j]==1) {
					return true;
				}
				
				
			}
		}
		return false;
	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	private static void bfs(int time) {
		
		boolean[][] visited = new boolean[r][c];
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));
		visited[0][0] = true;
		
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				
				Node temp = queue.poll();
				
				if(map[temp.x][temp.y]==1) {
					rest[temp.x][temp.y] = time;
					map[temp.x][temp.y] = 0;
					continue;
				}
				
				for(int j=0; j<4; j++) {
					int nx = temp.x + dx[j];
					int ny = temp.y + dy[j];
					
					
					if(0<=nx && nx < r && 0<= ny && ny < c && !visited[nx][ny]) {
						
						queue.add(new Node(nx, ny));
						visited[nx][ny]= true;
					}
					
				}
				
				
				
			}
			
			
			
			
		}
		
	}
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
