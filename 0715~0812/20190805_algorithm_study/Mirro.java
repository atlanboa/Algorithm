
public class Mirro {
	static int[][] map;
	public static void main(String[] args) {
		map = new int[][]{  {0,0,1,1,1,1,1,1},
							{1,0,0,0,0,0,0,1},
							{1,1,1,0,1,1,1,1},
							{1,1,1,0,1,1,1,1},
							{1,0,0,0,0,0,0,1},
							{1,0,1,1,1,1,1,1},
							{1,0,0,0,0,0,0,0},
							{1,1,1,1,1,1,1,0}
			};
			
		boolean[][] visited = new boolean[8][8];
		flag=false;
		dfs(0, 0, visited, 0);
		System.out.println(flag?"1":"-1");
		System.out.println(min== 999999999?"-1":min );
			
	}
	static int min = 999999999;
	static boolean flag = true;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	private static void dfs(int x, int y, boolean[][] visited, int cnt) {
//		종료, 실행, 자기호출
		if(cnt >= min) return;
		if(x == map.length-1 && y == map.length-1) {
			flag = true;
			if(min > cnt) {
				min = cnt; 
			}
			return;
		}
		
//		가지치기
		
		int tx;
		int ty;
		for(int i=0; i<4;i++) {
			tx = x + dx[i];
			ty = y + dy[i];
//			범위 체크
			if(tx < 0 || tx >= map.length || ty < 0 || ty >= map.length) {
				continue;
			}
//			실행
			if(map[ty][tx] == 0 && !visited[ty][tx]) {
				visited[ty][tx] = true;
				dfs(tx, ty, visited, cnt+1);
				visited[ty][tx] = false;
				
			}

			
			
			
		}
		
	}	
}
