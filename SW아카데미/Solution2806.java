package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2806 {
	static int[] chess;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			int n = Integer.parseInt(br.readLine());
			chess = new int[n];
			cnt = 0;
			backTracking(0, n);
			System.out.println("#"+t+" "+cnt);
			
		}

	}
	static int cnt;
	private static void backTracking(int depth, int n) {
		
		if(depth == n) {
			cnt++;
			return ;
		}
		
		for(int i=0; i<n; i++) {
			chess[depth]=i;
			if(isPromising(depth)) backTracking(depth+1, n);
		}
		
		
	}
	private static boolean isPromising(int depth) {
		boolean flag = true;
		
		for(int i=0; i<depth; i++) {
			if(chess[i]==chess[depth]) {
				flag = false;
				break;
			}
			
			if(Math.abs(chess[depth]-chess[i])==Math.abs(depth-i)) {
				flag = false;
				break;
			}
		}
		
		
		return flag;
	}
	
}
