import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5515 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] day = {3, 4, 5, 6, 0, 1, 2};
		int m, n;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int i=0; i<m-1; i++) {
				sum += days[i];
			}
			sum += n;
			
			sum %= 7;
			
			System.out.println("#"+t+" "+day[sum]);
			
		}

	}

}
