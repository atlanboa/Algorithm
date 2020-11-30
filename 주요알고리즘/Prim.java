package 주요알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=1;t<=T;t++) {
			
			queue = new PriorityQueue<>();
			int v, m;
			st = new StringTokenizer(br.readLine());
			
			v = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			
			graph = new ArrayList[v+1];
			visited = new boolean[v+1];
			visited[0]=true;
			for(int i=0; i<v+1; i++) {
				graph[i] = new ArrayList<Node>();
			}
			
			int from, to, weight;
			long sum = 0;
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());
				
				graph[from].add(new Node(from, to, weight));
				graph[to].add(new Node(to, from, weight));
				
			}
			
			
//			for(int i=0; i<v+1; i++) {
//				for(int j=0; j<graph[i].size();j++) {
//					Node temp = (Node) graph[i].get(j);
//					System.out.println(temp.from+" "+temp.to+" "+temp.weight);
//				}
////				System.out.println();
//			}
			
			sum = prim(1, v-1);
			
			System.out.println("#"+t+" "+sum);
			
		}

	}
	static PriorityQueue<Node> queue;
	static ArrayList graph[];
	static boolean[] visited;
	private static long prim(int vertex, int maxEdge) {
		long sum = 0;
		int cntEdge = 0;
		visited[vertex] = true;
		while(cntEdge < maxEdge) {
			
			for(int i=0; i<graph[vertex].size(); i++) {
				Node temp = (Node) graph[vertex].get(i); 
				
				if(!visited[temp.to]) {
					queue.add(new Node(temp.from, temp.to, temp.weight));					
				}
	
			}

			
			while(true) {
				
				Node temp = queue.poll();
				if(!visited[temp.to]) {
					visited[temp.to] = true;
					vertex = temp.to;
					cntEdge++;
					sum += temp.weight;
					break;
				}
				
				
				
			}
//			
			
		}
		return sum;
	}

	static class Node implements Comparable<Node>{
		int from;
		int to;
		int weight;
		
		public Node(int x, int y, int weight) {
			from = x;
			to = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight-o.weight;
		}
	}

}
