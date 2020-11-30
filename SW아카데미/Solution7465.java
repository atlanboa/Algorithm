package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution7465 {
	static int[] p;
	static ArrayList[] graph = new ArrayList[101];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			
			Arrays.fill(graph, new ArrayList<Integer>());
			
			int n, m;
			
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			p = new int[n+1];
			
			makeSet(p);
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from, to;
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				UnionSet(from, to);
			
				
			}
			HashSet<Integer> list = new HashSet<Integer>();
			for(int i=1; i<=n; i++) {
				findSet(i);
				list.add(p[i]);
			}
			
			System.out.println("#"+t+" "+list.size());
			
			
		}
	}
	private static void UnionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x == y) return;
		
		p[y] = x;
		
	}
	private static int findSet(int x) {
		if(x==p[x]) return x;
		int idx = findSet(p[x]);
		p[x] = idx;
		return idx;
	}
	private static void makeSet(int[] p) {
		for(int i=0; i<p.length;i++) {
			p[i] = i;
		}
		
	}

}
