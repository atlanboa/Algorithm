package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4299 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int d, h, m;
			d = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			m= Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			if(m-11< 0) {
				h--;
				sum += m+49;
			}
			else {
				sum += m-11;
			}
			
			if(h-11 < 0) {
				d--;
				sum += (h+13)*60;
			}else {
				sum += 60*(h-11);
			}
			
			if(d < 11) {
				sum = -1;
			}else {
				sum += (d-11)*1440;
			}
		
			System.out.println("#"+t+" "+sum);
			
		}

	}

}
