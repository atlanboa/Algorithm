package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author student
 *
 */
public class Solution2105 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] numbers;
	static int max;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];
			max = Integer.MIN_VALUE;
			numbers = new boolean[101];
			
			//map input
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());				
				}
			}
			
			
			
			for(int x=0; x<n-2; x++) {
				for(int y=1; y<n-1; y++) {
					Arrays.fill(numbers, false);
//					visited[x][y] = true;
					dfs(x, y, 0, 0, 0, x, y);
//					visited[x][y] = false;
				}
			}
			
			System.out.println("#"+t+" "+(max==Integer.MIN_VALUE||max <= 2?-1:max));
			
		}
	}
	

	/**
	 * @param x 다음 좌표 x
	 * @param y 다음 좌표 y
	 * @param d 방향
	 * @param dCnt 방향 전환 횟수
	 * @param cnt 카페 개수
	 * @param e_x
	 * @param e_y
	 * 
	 * 이미 방문한 숫자, dCnt >= 4, (x, y) 좌표 아웃
	 * 
	 */
	static int[][] dir = {{1, 1}, //우하
						 {-1, 1}, //우상
						 {-1, -1}, //좌상
						 {1, -1}}; //좌하
	private static void dfs(int x, int y, int d, int dCnt, int cnt, int e_x, int e_y) {
		
		if(dCnt >= 4) return;
		
		
		for(int i=0; i<4; i++) {
			
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			//범위 안이고, 같은 카페가 아니면 방문합니다.
			if(0 <= nx && nx < n && 0 <= ny && ny < n 
					&& !visited[nx][ny] && !numbers[map[nx][ny]]) {
				if(nx == e_x && ny == e_y) {
					//도착했으면
					if(max < cnt + 1) {
						max = cnt + 1;
					}
				}else {
					
					numbers[map[nx][ny]] = true;
					visited[nx][ny] = true;
					dfs(nx, ny, i, d==i?dCnt:dCnt+1, cnt+1, e_x, e_y);
					numbers[map[nx][ny]] = false;
					visited[nx][ny] = false;
					
				}
			}
			
			
			
		}
		
		
		
	}


}
