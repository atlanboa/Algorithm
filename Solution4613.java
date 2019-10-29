import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4613 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n, m;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			int[][] flag = new int[n][3];

			for (int i = 0; i < n; i++) {
				String line = br.readLine().trim();
				for (int j = 0; j < m; j++) {

					switch (line.charAt(j)) {
					case 'W':
						flag[i][1]++;
						flag[i][2]++;
						break;
					case 'B':
						flag[i][0]++;
						flag[i][2]++;
						break;
					case 'R':
						flag[i][0]++;
						flag[i][1]++;
						break;
					}

				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n - 2; i++) {
				for (int j = i + 1; j < n - 1; j++) {
					for (int k = j + 1; k < n; k++) {

						int sum = 0;

						for (int w = 0; w < j; w++) {
							sum += flag[w][0];
						}

						for (int b = j; b < k; b++) {
							sum += flag[b][1];
						}

						for (int r = k; r < n; r++) {
							sum += flag[r][2];
						}

						if (min > sum) {
							min = sum;
						}

					}

				}

			}
			
			System.out.println("#"+t+" "+min);

		}

	}
}
