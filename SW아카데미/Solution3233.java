package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3233 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		long d = 2;
		for(int t=1; t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			long a, b, n;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			n = a/b;
			long result = 0;
			result = (2*n+(n-1)*d*n)/2;
			
			System.out.println("#"+t+" "+result);
			
			
		}

	}

}
