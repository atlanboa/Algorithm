import java.util.Scanner;

public class Solution1284 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		int A, B;
		int p,q,r,s,w;
		for(int t=1; t<=T; t++) {
			p = sc.nextInt();
			q = sc.nextInt();
			r = sc.nextInt();
			s = sc.nextInt();
			w = sc.nextInt();
			
			A = w*p;
			if(w<=r) B = q;
			else B = q + (w-r)*s;
			
			System.out.format("#%d %d\n",t,A>B?B:A);
		}
	}

}
