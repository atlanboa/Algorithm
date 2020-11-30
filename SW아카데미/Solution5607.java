package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Solution5607 {
	static final int p = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			
			
			st = new StringTokenizer(br.readLine());
			int n, r;
			
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			int result = comb(n, r);
			
			System.out.println("#"+t+" "+result);
		}

	}

	private static int comb(int n, int r) {
		
		if(r==1) return n;
		if(n==r || r==0) return 1;
		
		
	
		return  (comb(n-1, r-1)%1234567891+ comb(n-1, r)%1234567891)%1234567891;
	}

}
