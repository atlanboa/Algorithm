import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1932 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] dp = new int[500][500];
	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine());
		
		
		int[][] triangle  = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
	
		dp[0][0] = triangle[0][0]; 
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				
				if(j==0) {
					dp[i][j] = triangle[i][j] + dp[i-1][j];
				}else{
					dp[i][j] = triangle[i][j]+Math.max(dp[i-1][j-1], dp[i-1][j]);	
				}
				
				
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			if(max < dp[n-1][i]) {
				max = dp[n-1][i];
			}
		}
		
		System.out.println(max);
	}

}
