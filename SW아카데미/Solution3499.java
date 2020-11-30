package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] words = new String[n];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<words.length; i++) {
				words[i] = st.nextToken();
			}
			
			
			System.out.print("#"+t+" ");
			int index = -1;
			if(words.length % 2 == 0) {
				index = words.length/2;
				for(int i=0; i<words.length/2; i++) {
					System.out.print(words[i]+" ");
					System.out.print(words[index++]+" ");
				}
			}else {
				index = words.length/2 +1;
				for(int i=0; i<=words.length/2; i++) {
					System.out.print(words[i]+" ");
					try {
						System.out.print(words[index++]+" ");	
					}catch (IndexOutOfBoundsException e) {
						break;
					}
					
				}
			}
			

			System.out.println();
			
//			System.out.println(Arrays.toString(words));
			
		}

	}

}
