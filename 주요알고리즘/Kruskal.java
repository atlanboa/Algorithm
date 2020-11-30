package 주요알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Kruskal {
	static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int v, e;

			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			TreeSet<Node> trunks = new TreeSet<>();
			
			p = new int[v+1];
				
			makeSet(p);
			
			int x, y, weight;
			for(int i=0; i<e;i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());
				
				trunks.add(new Node(x, y, weight));
				
			}
//			
			for(Node n:trunks) {
				System.out.println(n.ver1+" "+n.ver2+" "+n.weight);
			}
			
			long sum  = 0;
			int edge = 0;
			int size = trunks.size();
			for(int i=0; i<size; i++) {
				if(edge == v-1) break;
				
				Node temp = trunks.pollFirst();
				
				x = temp.ver1;
				y = temp.ver2;
				
				if(findSet(x)!=findSet(y)) {
					unionSet(x, y);
					sum += temp.weight;
					edge++;
				}
//				System.out.println(temp.ver1+" "+temp.ver2+" "+temp.weight);
				
			}

			System.out.println("#"+t+" "+sum);
			
		}
		
		
		

	}
	
	
	
	private static boolean unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x==y) {
			return true;
		}
		p[y] = x;	
		

		return false;
		
	}



	private static int findSet(int x) {
		if(x==p[x]) return x;
		int idx = findSet(p[x]);
		p[x]=idx;
		return idx;
	}



	private static void makeSet(int[] p) {
		for(int i=0; i<p.length; i++) {
			p[i]=i;
		}
		
	}



	static class Node implements Comparable<Node>{
		
		int ver1;
		int ver2;
		int weight;
		
		public Node(int x, int y, int weight) {
			ver1 = x;
			ver2 = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {

			return weight-o.weight < 0? 1:-1;
		}
		
		
	}

}
