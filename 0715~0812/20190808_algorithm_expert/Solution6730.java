import java.util.Scanner;

public class Solution6730 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int[] block = new int[n];
			
			for(int i=0; i<n; i++) {
				block[i] = sc.nextInt();
			}
			
			
			int up = 0;
			int down = 0;
			
			for(int i=0 ; i<n-1; i++) {
				if(block[i] > block[i+1] && block[i] - block[i+1] > down) {
					down =  block[i] - block[i+1];
					
				}else {
					if( block[i+1] - block[i] > up) {
						up = block[i+1] - block[i];
					}
				}
			}
			
			System.out.println("#"+t+" "+up+" "+down);
		}
	}

}
