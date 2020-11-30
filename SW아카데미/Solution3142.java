package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3142 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int n, m;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int unicorn, twinhorn;

			
			int temp = n%m;
			if(temp*2+(m-temp) == n) {
				unicorn = m-temp;
				twinhorn = temp;
			}else {
				unicorn = temp;
				twinhorn = m-temp;
			}
			
			System.out.println("#"+t+" "+unicorn+" "+twinhorn);
		}
		
		
	}

}
