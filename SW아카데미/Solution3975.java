package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3975 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			double a,b,c,d;
			a = Integer.parseInt(st.nextToken());
			b  = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			double alice = a/b;
			double bob = c/d;
			String result = null;
			if(alice > bob) {
				result = "ALICE";
			}else if (alice == bob) {
				result = "DRAW";
				
			}else {
				result = "BOB";
			}
			
			System.out.println("#"+t+" "+result);
			
			
		}

	}

}
