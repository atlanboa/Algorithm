package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4789 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			String str = br.readLine();
			char[] clients =  str.toCharArray();
			int sum = 0;
			int hire = 0;
			for(int i=0; i<clients.length; i++) {

				sum += clients[i]-'0';
				if(sum >= i+1) {
					continue;
					
				}else {
					hire += (i+1)-sum;
					sum += (i+1)-sum;
				}
				
			}
			
			System.out.println("#"+t+" "+(hire));
			
			
		}

	}

}
