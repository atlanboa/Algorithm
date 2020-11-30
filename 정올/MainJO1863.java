package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MainJO1863 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		st = new StringTokenizer(br.readLine());
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		p = new int[n + 1];
		makeSet();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a, b;

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			UnionSet(a, b);

		}

//		for (int i = 1; i < p.length; i++) {
//			findSet(i);
//		}
		int cnt = 0;
		for (int i = 1; i < p.length; i++) {
			cnt += i==p[i]?1:0;
		}
		sb.append(cnt);
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
