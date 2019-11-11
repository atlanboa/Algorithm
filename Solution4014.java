import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4014 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n, x;
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {

					map[i][j] = Integer.parseInt(st.nextToken());

				}

			}

			sb.append("#" + t + " ");

			int cnt = 0;

			// 가로 검사

			out: for (int i = 0; i < n; i++) {

				int cur = map[i][0];
				int size = 0;
				for (int j = 0; j < n; j++) {

					if (cur == map[i][j]) {
						size++;
					} else {// 경사로를 지어야 되는 경우

						// 높이 차가 -1인 경우(증가), size가 x 이상인 경우
						if (cur - map[i][j] == -1 && size >= x) {
							size = 1;
							cur = map[i][j];
						}
						// 높이 차가 1인 경우(감소), 다음 x칸에 설치할 수 있는지 확인
						else if (cur - map[i][j] == 1 && n - j >= x) {

							for (int k = j; k < j + x; k++) {
								if (map[i][j] != map[i][k]) {
									continue out;
								}
							}

							cur = map[i][j + 1];
							size = 0;
							j = j + x-1;

						}
						// 높이가 달라서 경사로를 설치해야 하는데 설치가 안될때는 다음 줄 검사
						else {
							continue out;
						}

					}

				} // j
//				System.out.println(i + "번째 라인 카운트");
				cnt++;
			}

			// 세로 검사
			out: for (int i = 0; i < n; i++) {
				int cur = map[0][i];
				int size = 0;
				for (int j = 0; j < n; j++) {

					if (cur == map[j][i]) {
						size++;
					} else {// 경사로를 지어야 되는 경우

						// 높이 차가 -1인 경우(증가), size가 2 이상인 경우
						if (cur - map[j][i] == -1 && size >= x) {
							size = 1;
							cur = map[j][i];
						}
						// 높이 차가 1인 경우(감소), 다음 2칸에 설치할 수 있는지 확인
						else if (cur - map[j][i] == 1 && n - j >= x) {
							for (int k = j; k < j + x; k++) {
								if (map[j][i] != map[k][i]) {
									continue out;
								}
							}

							cur = map[j + 1][i];
							size = 0;
							j = j + x-1;

						}
						// 높이가 달라서 경사로를 설치해야 하는데 설치가 안될때는 다음 줄 검사
						else {
							continue out;
						}

					}

				} // j
//				System.out.println(i + "번째 라인 카운트");
				cnt++;
			}
			sb.append(cnt + "\n");

		} // t

		System.out.println(sb.toString());

	}
}
