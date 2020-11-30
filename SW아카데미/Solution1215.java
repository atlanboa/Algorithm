package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1215 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int t=1;t<=10;t++) {
			
			int n = Integer.parseInt(br.readLine());
			String[] row = new String[8];
			String[] col = new String[8];
			for(int i=0; i<8; i++	) {
				row[i] = br.readLine();
			}
			
			for(int i=0; i<8; i++) {
				String temp = "";
				
				for(int j=0; j<8; j++) {
					
					temp = temp + row[j].charAt(i);
					
				}
				
				col[i] = temp;
			}
			int cnt = 0;
			StringBuilder sb = null;
			for(int i=0; i<8; i++) {
				
				for(int j=0; j<=8-n; j++) {
					String temp = row[i].substring(j, j+n); 
					
					sb = new StringBuilder(temp);
					if(temp.equals(sb.reverse().toString())) {
						cnt++;
					}
					
					temp = col[i].substring(j, j+n);
//					System.out.println(temp);
					sb = new StringBuilder(temp);
					if(temp.equals(sb.reverse().toString())) {
						cnt++;
					}
				}
				
				
				
				
			}
			
			System.out.println("#"+t+" "+cnt);
			
		}
		
		

	}

}
