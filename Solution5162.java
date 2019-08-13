import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5162 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T= Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int a, b, c ;
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int result = 0;
			if(a > b) result = c/b;
			else result = c/a;
			
			System.out.format("#%d %d\n",t,result);
			
		}
		

	}

}
