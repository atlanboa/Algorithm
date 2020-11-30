package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4522 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String temp = br.readLine();
			
			boolean flag = true;
			
			for(int i=0, j=temp.length()-1; i<= temp.length()/2; i++, j--) {
				System.out.println("i = "+temp.charAt(i)+" j = "+temp.charAt(j));
				if(temp.charAt(i) != temp.charAt(j)) {
					flag = false;
					if(temp.charAt(i) == '?' || temp.charAt(j) =='?')
					{
						flag = true;
					}
					else {
						break;
					}
				}
			}
			
			String result = "Not exist";
			if(flag) result = "Exist";
			
			
			System.out.println("#"+t+" "+result);
		}

	}

}