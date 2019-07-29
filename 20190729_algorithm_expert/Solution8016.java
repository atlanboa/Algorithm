import java.util.Scanner;

public class Solution8016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long n, lsum, rsum;
		for(int t=1;t<=T;t++) {
			n = sc.nextInt();
			lsum = 1 + ((n-1)*(4+4*(n-2)))/2;
			rsum = 1+ ((n-1)*(12+4*(n-2)))/2;;
			System.out.println("#"+t+" "+lsum+" "+rsum);
		
		}
	}

}


