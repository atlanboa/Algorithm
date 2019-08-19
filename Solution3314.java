import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution3314 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			
			while(st.hasMoreTokens()) {
				int score = Integer.parseInt(st.nextToken());;
				sum += score<40?40:score;
			}
			
			System.out.println("#"+t+" "+sum/5);
		}

	}

}
