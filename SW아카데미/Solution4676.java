package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			char[] word = br.readLine().toCharArray();
			int cnt = Integer.parseInt(br.readLine());
			int[] hyphon = new int[word.length+1];
			
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int pos = Integer.parseInt(st.nextToken());
				hyphon[pos]++;
			}
			
			
			System.out.print("#"+t+" ");
			
			for(int i=0; i<word.length; i++) {
				
				for(int j=0; j<hyphon[i]; j++) {
					System.out.print("-");
				}
				
				System.out.print(word[i]);
				
				
			}
			
			
			for(int i=0; i<hyphon[word.length]; i++) {
				System.out.print("-");
			}
			System.out.println();
			
		}

	}

}
