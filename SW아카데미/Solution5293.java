package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A: 00 , B: 01 , C: 10 , D: 11

public class Solution5293 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int A, B, C, D;

		for(int t=1; t<=T; t++) {
			result = null;
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			function(A, B, C, D, "0");
			function(A, B, C, D, "1");
			if(result == null) result = "impossible";
			
			System.out.format("#%d %s\n", t, result);			
			
			
			
			
			
		}

	}

	static String result;
	private static void  function(int a, int b, int c, int d, String str) {
		if(result != null) return;
		if(Math.abs(b-c) >= 2) return;
		if(a < 0 ||b < 0 ||c < 0 ||d < 0) return ;
		if(a == 0 && b==0 && c==0 && d==0) {
			//종료
			result = str;
		}
		

		
		
		if(str.charAt(str.length()-1) == '0') {
			function(a-1, b, c, d, str+"0");
			function(a, b-1, c, d, str+"1");
			return;
		}
		function(a, b, c-1, d, str+"0");
		function(a, b, c, d-1, str+"1");
	
	
		
	}

}
