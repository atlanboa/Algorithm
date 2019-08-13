import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5549 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String num = br.readLine();
			boolean flag = true;
			if((num.charAt(num.length()-1)-'0')%2 == 0) {
				flag = false;
			}
			
			if(flag) System.out.println("#"+t+" Odd");
			else System.out.println("#"+t+" Even");
			
		}
	}
}
