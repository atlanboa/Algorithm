import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17070 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][][] dp;
	static boolean[][] map;
	public static void main(String[] args) throws Exception{
		
		int n = Integer.parseInt(br.readLine());
		// 0 가로 1 대각 2 수직
		dp = new int[3][n+1][n+1];
		map = new boolean[n+1][n+1];
		dp[0][1][2] = 1;
		map[1][1] = true;
		map[1][2] = true;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					map[i][j] = true;
				}
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		
//		for(int i=0; i<=n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		for(int x=1; x<=n; x++) {
			for(int y=1; y<=n; y++) {
				if(!map[x][y]) {
					
					dp[0][x][y] = dp[1][x][y-1] + dp[0][x][y-1];
					if(!map[x-1][y] && !map[x][y-1]) {
						dp[1][x][y] = dp[0][x-1][y-1] + dp[1][x-1][y-1]+ dp[2][x-1][y-1];
					}
					dp[2][x][y] = dp[1][x-1][y]+ dp[2][x-1][y];
				}
			}
		}
		
		System.out.println(dp[0][n][n]+dp[1][n][n]+dp[2][n][n]);
		
	}
	/*
	 * 밀 수 있는 방향 오른쪽 , 대각 아래, 아래, 한번에 45도만 가능
	 * 오른쪽 : 오른쪽 ( 오른쪽 0 ), 대각 아래 ( 오른쪽 0, 대각 아래 0, 아래 0 )
	 * 대각 아래 : 오른쪽 ( 오른쪽 0), 대각 아래( 오른쪽 0, 대각 아래 0, 아래 0 ),  아래 ( 아래 0 )
	 * 아래 : 아래 ( 아래 0), 대각 아래 ( 오른쪽 0, 대각 아래 0, 아래 0 )
	 * 
	 * 한쪽 끝을 (n,n)으로 이동 시키는 방법
	 */
}
