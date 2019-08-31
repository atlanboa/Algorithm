import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int t=1;t<=10;t++) {
			String T = br.readLine();
			st = new StringTokenizer(br.readLine());
			int x, y;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			System.out.println("#"+t+" "+pow(x, y));
			
			
		}

	}

	private static int pow(int x, int y) {
		
		if(y==1) return x;
		
		return x * pow(x, y-1);
	}

}
