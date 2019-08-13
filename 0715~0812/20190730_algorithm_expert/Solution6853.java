import java.util.Scanner;

public class Solution6853 {
	static int[] state;
	static int x1, x2, y1, y2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T;t++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			
			state = new int[3];
			
			int n = sc.nextInt();
			
			for(int i=0; i<n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				state[check(x, y)]++;
			}
			
			
			System.out.println("#"+t+" "+state[0]+" "+state[1]+" "+state[2]);
			
			
		}
	

	}
	private static int check(int x, int y) {
		if(x < x1 || x > x2 || y < y1 || y > y2) return 2;
		else if( x > x1 && x < x2 && y > y1 && y < y2) return 0;
		else return 1;
	}

}
