package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7810 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			int n = Integer.parseInt(br.readLine());
			int[] num = new int[n];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<n; i++) {
				
				num[i] = Integer.parseInt(st.nextToken());
				
			}
			
			Arrays.sort(num);
			
			int h = -1;
			
			int index = 0;
			System.out.println(Arrays.toString(num));
			for(int i=0; i<num.length; i++	) {
				
				
					System.out.println(i+" "+index);
					while(index < num[i]) {
						
						if(n-i >= index) {
							h = index;
							index++;
						}else {
							break;
						}
						
						
					}

					
					
				
				
			}
			
			
			System.out.println("#"+t+" "+h);
		}

	}

}
