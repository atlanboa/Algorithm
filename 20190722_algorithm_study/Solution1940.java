import java.util.Scanner;

public class Solution1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;
		int a,v,d;
		for(int i=1; i<=t; i++) {
			n = sc.nextInt();
			a = 0;
			v = 0;
			d = 0;
			//입력되는 경우가 2가지, 0이거나 아니거나
			for(int j=0; j<n; j++) {
				int command = sc.nextInt();
				if(command != 0) {
					a=sc.nextInt();
					if(command == 1) v += a;
					else {
						v -= a;
						if( v<0) v=0;
					}
				}
				d += v;
			}
			
			

			System.out.printf("#%d %d\n",i,d);
		}
	}

}
