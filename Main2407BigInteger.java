import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main2407BigInteger {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static BigInteger[][] b= null;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		b = new BigInteger[n+1][m+1];
		b[0][0] = BigInteger.ONE;
		bino2(n, m);
//		for(int i=0; i<n+1; i++) {
//			System.out.println(Arrays.toString(b[i]));
//		}
		
		System.out.println(b[n][m]);
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
