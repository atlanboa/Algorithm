package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class Main1717 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[] p;
	public static void main(String[] args) throws IOException {
		int n, m;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		makeSet(p);
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int op, a, b;
			op = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			switch (op) {
			case 0:
				unionSet(a, b);
				break;

			case 1:
				if(findSet(a)==findSet(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
				break;
			}
			
		}
		
		
	}
	private static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x==y) {
			return;
		}
		p[y]=x;
	}
	private static int findSet(int x) {
		if(x==p[x]) return x;
		
		int idx = findSet(p[x]);
		p[x]=idx;
		
		
		return idx;
	}
	private static void makeSet(int[] p) {
		for(int i=0; i<p.length; i++) {
			p[i] = i;
		}
	}

}
