package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1216{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int t=1;t<=10;t++) {
			t = Integer.parseInt(br.readLine());
			
			String[] row = new String[100];
			String[] col = new String[100];
			for(int i=0; i<100; i++	) {
				row[i] = br.readLine();
			}
			
			for(int i=0; i<100; i++) {
				String temp = "";
				
				for(int j=0; j<100; j++) {
					
					temp = temp + row[j].charAt(i);
					
				}
				
				col[i] = temp;
			}
			int n = 0;
			StringBuilder sb = null;
			for(int i=0; i<100; i++) {
				for(int k=1; k<=100; k++) {
					for(int j=0; j<=100-k; j++) {
						String temp = row[i].substring(j, j+k); 
						
						sb = new StringBuilder(temp);
						if(temp.equals(sb.reverse().toString())) {
							if(k > n) {
								n = k;
							}
						}
						
						temp = col[i].substring(j, j+k);

						sb = new StringBuilder(temp);
						if(temp.equals(sb.reverse().toString())) {
							if(k > n) {
								n = k;
							}
						}
					}

				}
								
				
				
				
			}
			
			System.out.println("#"+t+" "+n);
			
		}
		
		

	}

}
