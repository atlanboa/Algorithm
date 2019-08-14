import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4698 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean[] prime = new boolean[1000001];
		prime[0] = true;
		prime[1] = true;
		for(int i=2; i*i<1000001; i++) {
			if(!prime[i]) {
				
				for(int j=i*i;j<1000001; j+=i) {
					prime[j] = true;
				}
				
			}
		}
		

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String d; 
			int a, b;
			d = st.nextToken();
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			
			int cnt = 0;
			for(int i=a; i<=b; i++	) {
				
				if(!prime[i] && Integer.toString(i).contains(d)) {
					cnt++;
				}
					
				
				
			}
			
			System.out.format("#%d %d\n",t, cnt);
		}

	}

}
