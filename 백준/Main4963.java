package 백준;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

//4973. 섬의 개수
public class Main4963 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int w, h;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new char[h][w];
			visited = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			
//			for(int i=0; i<h; i++) {
//
//				System.out.println(Arrays.toString(map[i]));
//			}
			cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
//					if(visited[i][j] || map[i][j]=='0') continue;
//					System.out.println(i+" "+j);
					if(!visited[i][j] && map[i][j]=='1') {
						bfs(i, j, map, visited);	
					}
					
					
				}
			}
//			System.out.println();
			bw.write(cnt+"\n");
		}
		bw.flush();
		bw.close();
	}
	static int cnt;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	private static void bfs(int i, int j, char[][] map, boolean[][] visited) {
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(i, j));
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
//			System.out.println(temp);
			for(int dir=0; dir<8; dir++) {
				int nx, ny;
				nx = temp.x + dx[dir];
				ny = temp.y + dy[dir];
				
				if (0 <= nx && nx < h && 0 <= ny && ny < w 
						&& !visited[nx][ny] && map[nx][ny]=='1') {
//					System.out.println("nx : "+nx+" ny : "+ny);
					queue.add(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
			
		}
		
		cnt++;
//		System.out.println(cnt);
	}
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
}
