package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			
			
			
			String str = br.readLine();
			
			System.out.print("#"+t+" ");
			
			for(char a:str.toCharArray()) {
				switch(a){
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						continue;
				}
				System.out.print(a);
			}
			
			System.out.println();
		}

	}

}
