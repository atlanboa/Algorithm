package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8338 {
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int[] num = new int[n];
			
			for(int i=0; i<n;i++) {
				
				num[i] = Integer.parseInt(st.nextToken());
				
			}
			
			max = 0;
			
			permutation(num, 0, n, 0);
			
				
			System.out.println("#"+t+" "+max);
			
		}
	}
	private static void permutation(int[] num, int depth, int n, int result) {
		
		if(depth >= n) {
			if(result > max) max = result;
			return;
		}
		
		if(depth == 0) {
			permutation(num, depth+1, n, num[depth]);
			permutation(num, depth+1, n, num[depth]);
		}else {
			permutation(num, depth+1, n, result+num[depth]);
			permutation(num, depth+1, n, result*num[depth]);
		}
		
		
		
		
		
		
	}

}
