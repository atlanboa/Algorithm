import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5986 {
	static int cnt;
	static int[] prime = new int[168];
	static int[] prime2 = new int[3000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int n = 0;
		int index = 2;
		prime[0] = 2;
		prime[1] = 3;
		
		for(int i=4; i<=999; i++) {
			if(isPrime(i)) {
				prime[index++] = i;
			}
		}
		for(int i=0; i<prime.length; i++) {
			for(int j=i; j<prime.length; j++) {
				for(int k=j; k<prime.length; k++) {
					
					prime2[prime[i]+prime[j]+prime[k]]++;

				}
			}
		}
		
		for(int t=1; t<=T; t++) {
			cnt = 0;
			n = Integer.parseInt(br.readLine());
			

			
			System.out.format("#%d %d\n",t,prime2[n]);
		}
		
		

	}
	
	
	
	private static void dfs(int n, int depth, int sum) {
		if(sum > n) return;
		if(depth == 3) {
			if(sum == n) {
				cnt++;
				return;
			}else {
				return;
			}
		}
		
		
		for(int i=0; i<prime.length; i++) {
			if(prime[i] > n) break;
			else dfs(n, depth+1, sum + prime[i]);
		}
		
	}
	private static boolean isPrime(int num) {
		
		
		for(int i=2; i<=Math.sqrt(num); i++	) {
			if(num%i == 0) return false;
		}
		
		return true;
	}


}
