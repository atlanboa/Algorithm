package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution6782WS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			long N = Long.parseLong(br.readLine());
			int cnt = 0;
	        while (N != 2) {
	            long sqrt = (long) Math.sqrt(N);
	            if (sqrt * sqrt == N) {
	                cnt++;
	                N = sqrt;
	            } else {
	                long tempL = sqrt + 1;
	                cnt += tempL * tempL - N;
	                N = tempL * tempL;
	            }
	        }
			System.out.println("#"+t+" "+cnt);
			
			
		}
	}
	

}