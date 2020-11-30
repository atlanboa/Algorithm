package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution4466 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			int n, k;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				list.add(Integer.parseInt(st.nextToken()));	
			}
			
			Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {

					return o2-o1;
				}
			});
			int sum = 0;
			
			for(int i=0; i<k; i++) {
				sum += list.get(i);
			}
			
			System.out.println("#"+t+" "+sum);
		}

	}

}
