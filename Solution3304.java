import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			
			char[] str1 = st.nextToken().toCharArray();
			
			char[] str2 = st.nextToken().toCharArray();
			
			
			int[][] dp = new int[str1.length+1][str2.length+1];

			
			int length = lcs(dp, str1, str2);
			System.out.println("#"+t+" "+length);
		}
		
	}

	private static int lcs(int[][] dp, char[] str1, char[] str2) {
		int max = -1;
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);	
				}

			}
		}
		
		max = dp[dp.length-1][dp[0].length-1];
		
		return max;
	}

}
