import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10844 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	static long[][] dp = new long[101][10];
	static final long P = 1000000000;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		//1자리수 초기화
		for(int i=1; i<10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=100; i++) {
			for(int j=0; j<10; j++) {
				if(j == 0) dp[i][0] = dp[i-1][1];
				else if(j==9) dp[i][9] = dp[i-1][8];
				else dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%P;
			}
		}
		
		
		System.out.println(getSum(N));
		
	}



	private static long getSum(int n) {
		
		long sum = 0;
		for(int i=0; i<10; i++) {
			sum = (sum+dp[n][i])%P; 
		}
		
		return sum;
	}
}
