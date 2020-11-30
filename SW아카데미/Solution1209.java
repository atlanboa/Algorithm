package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1209 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int t=1;t<=10;t++) {
			
			t  = Integer.parseInt(br.readLine());
			
			int[][] map = new int[100][100];
			
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());					
				}
	
			}
			
			
			System.out.println("#"+t+" "+sum(map));
			
			
			
		}
		

	}

	private static int sum(int[][] map) {
		int max = Integer.MIN_VALUE;
		int sumCol=0;
		int sumRow=0;
		
		for(int i=0; i<100; i++) {
			sumCol = 0;
			sumRow = 0;
			for(int j=0; j<100; j++) {
				sumCol += map[j][i];
				sumRow += map[i][j];
			}
			
			if(sumCol > max) max = sumCol;
			if(sumRow > max) max = sumRow;
		}
		
		int sumDia = 0;
		for(int i=0; i<100; i++) {
			
			sumDia += map[i][i];
			
			
		}
		
		if(sumDia > max) max = sumDia;
		
		sumDia = 0;
		for(int i=0; i<100; i--) {
			sumDia += map[i][99-i];
		}
		if(sumDia > max) max = sumDia;
		
		return max;
	}

}
