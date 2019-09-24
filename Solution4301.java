import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] map = new int[1000][1000];
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		search();
		
		
		for(int t=1;t<=T;t++) {
			
			st = new StringTokenizer(br.readLine());
			int n, m;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			int result = getCnt(n, m);
			System.out.println("#"+t+" "+result);
		}
		
		
		
	}



	private static int getCnt(int n, int m) {
		int cnt = 0;
		for(int i=0; i<n; i++	) {
			for(int j=0; j<m; j++) {
				
				if(map[i][j] == 1) {
					cnt++;
				}
				
				
			}
		}
			
		return cnt;
	}



	static int[] dx = {2, -2, 0, 0};
	static int[] dy = {0, 0, 2, -2};
	private static void search() {
		
		for(int i=0; i<1000; i++) {
			for(int j=0; j<1000; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					for(int d=0; d<4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if(nx >= 0 && ny >=0 && nx < 1000 && ny < 1000) {
							map[nx][ny] = 2;
						}
						
					}
				}
				
				
				
			}
		}
		
	}
}
