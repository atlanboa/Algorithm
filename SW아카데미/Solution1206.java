package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1206 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int t=1;t<=10;t++) {
			
			int n = Integer.parseInt(br.readLine());
			int[] street = new int[n+4];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=2; i<n+2;i++) {
				street[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
			
			System.out.println("#"+t+" "+getSight(street));
			
			
		}

	}

	private static int getSight(int[] street) {
		int sum = 0;
		
		for(int i=2; i<street.length-2; i++) {
			
			sum += chk(street, i);
			
			
		}
		
		return sum;
	}

	private static int chk(int[] street, int i) {
		;
		int min = Integer.MAX_VALUE;
		int temp = -1;
		if(street[i] > street[i-1] && street[i] > street[i-2]
				&& street[i] > street[i+1] && street[i] > street[i+2]) {
			
			
			temp = street[i]-street[i-1];
			if(min > temp) min = temp;
			temp = street[i]-street[i-2];
			if(min > temp) min = temp;
			temp = street[i]-street[i+1];
			if(min > temp) min = temp;
			temp = street[i]-street[i+2];
			if(min > temp) min = temp;
			
			
			if(min > 0) return min;
			
		}
		
		
		return 0;
	}

}
