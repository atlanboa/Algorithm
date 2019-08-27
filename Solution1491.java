import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1491{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		
		for(int t=1;t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			long n, a, b;
			n = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			long value, min = Long.MAX_VALUE;
			
			for(long C=1; C<=n/2; C++) {
				for(long R=C; C*R<=n; R++) {
					value = a*(R-C) + b*(n-R*C);
					if(value<min) min=value;
				}
			}
			
			
			System.out.println("#"+t+" "+min);
		}
		
	}



}
