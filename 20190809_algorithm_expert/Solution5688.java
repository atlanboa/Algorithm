import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5688 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			long n = Long.parseLong(br.readLine());
			int r = -1;
			
			for(int i=1; i<=(int) Math.sqrt(n); i++) {
				long mult = 1;
				mult = mult*i*i*i;
				if(mult == n) {
					r = i;
					break;
				}
				else if(mult > n) {
					break;
				}

			}
			
			System.out.println("#"+t+" "+r);
		}

	}



}
