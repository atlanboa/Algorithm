package 백준;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main1010 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static BigInteger[][] b= new BigInteger[31][31];
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		
		bino2(30, 30);
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			System.out.println(b[m][n]);
		}
		
		
	}
	private static void bino2(int n, int m) {
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=i && j<=m; j++) {
				if(j == i || j==0) {
					b[i][j] = BigInteger.ONE;
				}else {
					b[i][j] = b[i-1][j-1].add(b[i-1][j]);	
				}
				
			}
		}
		
	}
}
