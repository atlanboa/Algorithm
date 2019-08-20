import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution3282 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			int n, k;
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[n+1][k+1];
			
			int[][] stuff = new int[n+1][2];
			for(int i=1; i<n+1; i++) {
				st = new StringTokenizer(br.readLine());
				stuff[i][0] = Integer.parseInt(st.nextToken());
				stuff[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(stuff, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {

					return o1[0]-o2[0];
				}
			});
			
			
			for(int i=1; i<dp.length; i++) {
				for(int j=1; j<dp[0].length; j++) {
					if(j < stuff[i][0]) { 
						dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);	
					}else {
						dp[i][j] = Math.max(Math.max(dp[i][j-1], dp[i-1][j]), dp[i-1][j-stuff[i][0]]+stuff[i][1]);
					}
					
					
					
				}
			}
			
			
			System.out.println("#"+t+" "+dp[dp.length-1][dp[0].length-1]);
		}

	}

}
