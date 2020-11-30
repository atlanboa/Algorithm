package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3750 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String n = br.readLine();
			
			while(!(n.length()==1)) {
				n = f(n);
			}
			
			System.out.println("#"+t+" "+n);
		}
	}

	private static String f(String n) {
		int sum = 0;
		for(char a: n.toCharArray()) {
			sum += a-'0';
		}
		
		
		return Integer.toString(sum);
	}

}
