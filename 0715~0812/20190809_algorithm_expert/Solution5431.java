import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5431 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		int k, n;
		boolean[] handed = null;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			handed = new boolean[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<k; i++) {
				handed[Integer.parseInt(st.nextToken())]= true;
			}
			
			System.out.print("#"+t+" ");
			for(int i=1; i<=n; i++) {
				if(!handed[i]) System.out.print(i+" ");
			}
			System.out.println();
		}

	}

}
