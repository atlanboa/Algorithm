package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1220 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int t=1;t<=10;t++) {
			
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			
			StringTokenizer st = null;
			for(int i=0; i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					
					map[i][j] = Integer.parseInt(st.nextToken());
					
					
				}
			}
			

			int cnt = 0;
			for(int i=0; i<n; i++) {
				
				boolean flagN = false;
				
				for(int j=0; j<n; j++) {
					
			
					
					if(!flagN && map[j][i]==1) {
						flagN = true;
					}
								
					
					if(flagN && map[j][i]==2) {
						cnt++;
						flagN = false;
					}

					
					
				}
				
			
				
			}
			
			System.out.println("#"+t+" "+cnt);
			
			
			
			
			
		}
		
		

	}

}
