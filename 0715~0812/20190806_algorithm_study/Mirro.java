import java.util.LinkedList;

public class Mirro {
	static int[][] map;
	public static void main(String[] args) {
		map = new int[][]{  {0,0,1,1,1,1,1,1},
							{1,0,0,0,0,0,0,1},
							{1,1,1,0,1,1,1,1},
							{1,1,1,0,1,1,1,1},
							{1,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0},
							{1,1,1,1,1,1,1,0}
			};
			
		boolean[][] visited = new boolean[8][8];

		bfs(0, 0, visited);
//		System.out.println(flag?1:-1);
		System.out.println(min==99999999?-1:min);
			
	}
	
	
	static int min = 999999999;
	static boolean flag = false;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	private static void bfs(int x, int y, boolean[][] visited) {

		LinkedList<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, 0));
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			visited[temp.x][temp.y] = true;
			
			if(temp.x == map.length-1 && temp.y == map.length-1) {
//				System.out.println("도착");
				if(min > temp.cnt) min = temp.cnt;
//				flag = true;
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];
				
				if(tx >=0 && tx <=7 && ty >=0 && ty<=7 && !visited[tx][ty] && map[tx][ty] == 0) {
					q.offer(new Point(tx, ty, temp.cnt+1));
				}
				
			}
			
			
			
			
		}
		
	}
	
	
	static class Point{
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
}
