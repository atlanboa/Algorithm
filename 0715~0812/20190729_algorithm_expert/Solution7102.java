import java.util.Scanner;

public class Solution7102 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, M, max;
		int[] cnt;
		for(int t=1; t<=T;t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			cnt = new int[N+M+1];
			max = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					cnt[i+j]++;
				}
			}
			
			System.out.print("#"+t+" ");
			for(int i=0; i<cnt.length; i++) {
				if(max < cnt[i]) max = cnt[i];
			}
			for(int i=0; i<cnt.length;i++) {
				if(cnt[i] == max) System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}
