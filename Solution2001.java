package expertAlgo;

import java.util.Scanner;

public class Solution2001 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int[n][n];
			
			for(int j=0; j<arr.length; j++) {
				for(int k=0; k<arr.length; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			for(int j=0; j<n-m+1; j++) {
				for(int k=0; k<n-m+1; k++) {
					int sum = 0;
					for(int r=0; r<m; r++) {
						for(int c=0; c<m; c++) {
							sum += arr[r][c];
						}
					}
					if(sum > max) max = sum;
				}
			}
			
			System.out.printf("#%d %d\n",i, max);
			// n-m+1
		
			
		}
	}

}
