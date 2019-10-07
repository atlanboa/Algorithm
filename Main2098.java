import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2098 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {

		n = Integer.parseInt(br.readLine());

		dp = new long[n][1 << n];
		w = new int[n][n];// weight array

		// dp배열과 weight의 초기값 설정
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {

				w[i][j] = Integer.parseInt(st.nextToken());
				if(w[i][j]==0) {
					w[i][j] = INF;
				}
			}
			w[i][i] = 0;
			Arrays.fill(dp[i], -1);
		}
		
		

		System.out.println(solve(0, 1 << 0));

	}

	static long[][] dp;
	static int[][] w;
	static int n;
	private static long solve(int cur, int B) {
		//
		if(dp[cur][B] != -1) return dp[cur][B];//방문된 정점이면
		
		if(B == (1<<n)-1) //모든 정점이 방문된 경우
			return dp[cur][B] = w[cur][0] != INF ? w[cur][0] : INF;
			
		dp[cur][B] = INF;
		for(int i=0; i<n; i++) {
			if(w[cur][i] == INF || (B & (1<<i)) > 0) continue;
			
			dp[cur][B] = Math.min(dp[cur][B], solve(i, B | (1 << i ))+w[cur][i]);
		}
		
		
		return dp[cur][B];
	}

}
