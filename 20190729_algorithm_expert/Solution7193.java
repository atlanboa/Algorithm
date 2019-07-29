import java.util.Scanner;

public class Solution7193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n;
		String x;
		int num;
		for(int t=1; t<=T; t++) {
			num = 0;
			n = sc.nextInt();
			x = sc.next();
		
			System.out.println(x);
			for(char ch:x.toCharArray()) {
				num += (ch-'0');
			}
			
			System.out.format("#%d %d\n",t,num%(n-1));
			
			
			
			
		}
		
	}

}
