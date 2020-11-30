package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main1863 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		makeSet(p);
		int x;
		int y;
		for(int i=0; i<m; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			unionSet(x, y);
			
		}
		
		
		TreeSet<Integer> list = new TreeSet<>();
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			
//			list.add(findSet(i));
			if(p[i]==i) cnt++;
			
		}
		

		System.out.println(cnt);

	}

	private static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x == y) {
			return;
		}
		p[y] = x;
		
	}

	private static int findSet(int x) {
		if(x==p[x]) return x;
		int idx = findSet(p[x]);
		p[x]=idx;
		return idx;
	}

	private static void makeSet(int[] p) {
		for(int i=1; i<p.length;i++) {
			
			p[i] = i;
			
		}
		
	}

}
