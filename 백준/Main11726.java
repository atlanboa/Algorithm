package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11726 {
	static long[] dp = new long[1001];
	static final int p = 10007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<1001; i++) {
			dp[i] = (dp[i-1]%p+dp[i-2]%p)%p;
		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(dp[n]);
	}

}
