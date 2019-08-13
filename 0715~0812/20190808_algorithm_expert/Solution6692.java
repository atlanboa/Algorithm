import java.util.Scanner;

public class Solution6692 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n, x;
		double p, sum;
		for(int t=1; t<=T; t++) {
			sum = 0;
			n = sc.nextInt();
			for(int i=0; i<n; i++) {
				p = sc.nextDouble();
				x = sc.nextInt();
				
				sum += p*x;
			}
			
			System.out.format("#%d %.6f\n",t,sum);
			
		}
	}
}
