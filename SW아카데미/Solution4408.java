package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4408 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			
			boolean[][] room = new boolean[n][401];
			
			
			for(int i=0; i<n; i++) {
				int num1, num2;
				st = new StringTokenizer(br.readLine());
				num1 = Integer.parseInt(st.nextToken());
				num2 = Integer.parseInt(st.nextToken());
				
				if(num1 > num2) {
					int temp = num1;
					num1 = num2;
					num2 = temp;
				}
				
				if(num2 % 2 != 0) num2++;
				for(int j=num1; j<=num2; j++) {
					room[i][j] = true;
				}
				
			}
			int max = -1;
			for(int i=0; i<401; i++) {
				int cnt = 0;
				for(int j=0; j<n; j++) {
					
					if(room[j][i]) cnt++;
					
					
				}
				if(cnt > max) max = cnt;
			}
			
			
			
			System.out.println("#"+t+" "+max);
			
		}
				

	}

}
