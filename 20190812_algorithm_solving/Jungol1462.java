import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

//1462 : 보물섬 bfs
public class Jungol1462 {
	static boolean[][] map = null;
	static int row;
	static int col;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());		
		map = new boolean[row][col];
		
		for(int i=0; i<row; i++	) {
			String line = br.readLine();
			for(int j=0; j<col; j++) {
				if(line.charAt(j)=='W') {
					map[i][j] = true;
				}
			}
		}
		
		int max = 0;
		int cur = 0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(!map[i][j]) {
					cur = bfs(i, j);
					if(max < cur) {
						max = cur;
					}
				}
			}
		}

		System.out.println(max-1);
		
	}
	static boolean[][] visited = null;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	private static int bfs(int x, int y) {
		LinkedList<Node> list = new LinkedList<>();
		visited = new boolean[map.length][map[0].length];
		list.add(new Node(x, y));
		visited[x][y] = true;
		int level = 0;
		
		while(!list.isEmpty()) {
			
			int size = list.size();
			
			for(int i=0; i<size; i++) {
				Node temp = list.poll();
				
				for(int j=0; j<4; j++) {
					int nx = temp.x + dx[j];
					int ny = temp.y + dy[j];
					
					if( 0<=nx && nx<row && ny >= 0 && ny < col && !visited[nx][ny] && !map[nx][ny]) {
						visited[nx][ny] = true;
						list.add(new Node(nx, ny));
					}
					
					
				}
				
				
				
			}
			level++;
			
		}
		
		
		
		
		return level;
	}

	
}

class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}