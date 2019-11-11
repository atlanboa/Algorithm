import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3289 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			sb.append("#" + t + " ");

			st = new StringTokenizer(br.readLine());
			int n, m;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			p = new int[n + 1];
			makeSet();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op, a, b;
				op = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				if (op == 0) {
					UnionSet(a, b);
				} else {
					if (findSet(a) == findSet(b)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}

			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

	private static void UnionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);

		if (x == y) {
			return;
		}

		p[y] = x;

	}

	private static int findSet(int x) {
		if (x == p[x])
			return x;
		int idx = findSet(p[x]);
		p[x] = idx;
		return idx;

	}

	private static void makeSet() {

		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}

	}

}
