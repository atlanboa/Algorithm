import java.util.Scanner;

public class Solution7964 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, D, cnt, gate, ext;
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			D = sc.nextInt();
			
			cnt = 0;
			ext = 0;
			for(int i=0; i<N; i++) {
				gate = sc.nextInt();
				if(gate == 1) cnt = 0;
				else cnt++;
				
				if(cnt == D) {
					ext++;
					cnt = 0;
				}
			}
			
			System.out.format("#%d %d\n",t, ext);
		}

	}

}
