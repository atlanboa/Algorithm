package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3408 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			long n = Integer.parseInt(br.readLine());
			
			long s1 =0;
			s1 = (n*(n+1))/2;
			long s2 = 0;
			s2 = (n*(2*1+(n-1)*2))/2;
			long s3 = 0;
			s3 = (n*(2*2+(n-1)*2))/2;
			
			System.out.println("#"+t+" "+s1+" "+s2+" "+s3);
		}

	}


}
