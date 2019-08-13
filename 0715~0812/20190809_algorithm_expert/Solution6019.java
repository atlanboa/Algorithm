import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6019 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		double d, a, b, f;
		for(int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			d = Double.parseDouble(st.nextToken());
			a = Double.parseDouble(st.nextToken());
			b = Double.parseDouble(st.nextToken());
			f = Double.parseDouble(st.nextToken());
			
			double result = (d/(a+b))*f;
			
			System.out.format("#%d %.10f\n",t,result);
			
			
		}
		

	}

}
