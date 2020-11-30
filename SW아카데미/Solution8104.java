package SW아카데미;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution8104 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n, k;
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			int[] group = new int[k];

		
			
			int next = 1;
			int temp = 1;
			for (int i = 0; i < n; i++) {
				
				for(int j =0; j<k; j++) {
					
					
//					System.out.println(i+" "+temp);
					group[j] += temp;
					temp += next;
					
					
					
				}
				
				if(next == -1) {
					temp++;
				}else {
					temp--;
				}
				
				temp += k;
				next *= -1;
				
			}

			System.out.print("#" + t + " ");
			for(int i=0; i<k; i++) {
				System.out.print(group[i]+" ");
			}
			System.out.println();

		}

	}

}
