package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2133 {
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		int answer = 0;
		if(n % 2 == 0) {
			dp[0] =1;
			dp[2] = 3;
			for(int i=4; i<=n; i+=2) {
				for(int j=2; j<=i; j+=2) {
					int standard = j == 2?3:2;
					dp[i] += standard * dp[i - j];
					
				}
			}
			answer = dp[n];
		}
		
		System.out.println(answer);
		
	}


	

}
