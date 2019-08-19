import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3431 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int l, u, x;
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			int result = x < l? l-x:( x > u? -1:0);
			
			System.out.println("#"+t+" "+result);
			
		}

	}

}
