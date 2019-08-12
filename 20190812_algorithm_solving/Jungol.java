import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jungol {
	static int cnt;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		int r, c, s, k;
		cnt =1;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
	
		
		System.out.println(	bfs(r, c, s, k));
		
	}
	static Queue<Node> list = new LinkedList<>();
	static int[] dx = {2,1,-1,-2,-2,-1,1,2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	static boolean[][] visited = new boolean[101][101];
	
	private static int bfs(int tx, int ty, int rx, int ry) {
		list.add(new Node(tx, ty));
		visited[tx][ty] = true;
		int level = 0;
		while(!list.isEmpty()) {
			
			
			int size = list.size();
			for(int j=0; j<size; j++) {
				
				Node temp = list.poll();	
				
				if(temp.x == rx && temp.y == ry) {
					return level;
				}
				for(int i=0; i<dx.length; i++) {
					int nx = temp.x + dx[i];
					int ny = temp.y + dy[i];
					if(1<= nx && nx<=n && ny >= 1 && ny <= m && !visited[nx][ny]) { 
						visited[nx][ny] = true;
						list.add(new Node(nx, ny));				
					
					}
				}
			}
			level++;

		}
		
		return 0;
		
	}

}

class Node{
	int x;
	int y;
	public Node(int x , int y) {
		this.x = x;
		this.y = y;
	}
}