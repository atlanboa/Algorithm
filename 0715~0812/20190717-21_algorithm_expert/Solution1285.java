import java.util.Scanner;

public class Solution1285 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, cnt, min, temp;

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();

			cnt = 0;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				temp = Math.abs(sc.nextInt());
				if (min > temp) {
					cnt = 1;
					min = temp;
				} else {
					if (min == temp)
						cnt++;
				}

			}
			System.out.format("#%d %d %d\n", t, min, cnt);
		}
	}

}
