package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3307 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=1;t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n+1];
			int[] dp = new int[n+1];
			st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<n+1;i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			int max = -9999;
			for(int i=1; i<n+1; i++) {
				dp[i] = dp[findIndex(dp, nums, nums[i], i-1)] + 1;
				if(dp[i]>max) max = dp[i];
			}
			
			System.out.println("#"+t+" "+max);
		}

	}

	private static int findIndex(int[] dp, int[] nums, int num, int start) {
		int ret  = -1;
		int max = -9999;
		for(int i = start; i>=0; i--) {
			if(nums[i] <= num && dp[i] >= max) {
				max = dp[i];
				ret = i;
				
			}
		}
		
		return ret;
	}

}
