import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1149 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][3];
		int[][] dp  = new int[n][3];
		for(int i=0; i<n; i++) {
			int r,g,b;
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			cost[i][0] =r;
			cost[i][1] =g;
			cost[i][2] =b;
		}
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		
		for(int i=1; i<n; i++) {
			dp[i][0] = Math.min(dp[i-1][1]+cost[i][0], dp[i-1][2]+cost[i][0]); //red 니깐 red빼고 초록1 파랑2
			dp[i][1] = Math.min(dp[i-1][0]+cost[i][1], dp[i-1][2]+cost[i][1]);
			dp[i][2] = Math.min(dp[i-1][0]+cost[i][2], dp[i-1][1]+cost[i][2]);
		}
		
		
		System.out.println(Math.min(dp[n-1][2], Math.min(dp[n-1][0], dp[n-1][1])));
		
		
	}

}

