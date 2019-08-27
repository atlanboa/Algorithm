import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1289 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			char[] bits = br.readLine().toCharArray();
			
			
			
			int cnt = 0;
			boolean flag = true;
			for(int i=0; i<bits.length;i++) {
				
				if(flag) {
					if(bits[i]=='1') {
						flag = false;
						cnt++;
					}
				}else {
					if(bits[i]=='0') {
						flag = true;
						cnt++;
					}
				}
				
				
			}
			
			System.out.println("#"+t+" "+cnt);
			
		}
	}

}
