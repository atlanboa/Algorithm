import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Soltuion2814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int T = Integer.parseInt(br.readLine());
		int x, y, n, m;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken())+1;
			m = Integer.parseInt(st.nextToken());
						
			graph = new Node[n];
			for(int i=0; i<n;i++) {
				graph[i] = new Node();
			}
			
			
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				graph[x].next.add(y);
				graph[y].next.add(x);
				
			}
			max = Integer.MIN_VALUE;
			
			
			for(int i=1; i<n; i++) {
				
				visited = new boolean[n];
				dfs(i, 1);

			}
			System.out.println("#"+t+" "+max);
		}

	}
	static int max;
	private static void dfs(int index, int vertex) {
		
		
		visited[index]=true;
		
		for(int v:graph[index].next) {
			if(!visited[v]) {
				dfs(v, vertex+1);
				visited[v] = false;
			}
			
		}
		
		if(vertex > max) max = vertex;
		
	}
	static Node[] graph;
	static boolean[] visited;
	static class Node{
		ArrayList<Integer> next;
		
		public Node() {
			next = new ArrayList<>();
		}
		
		
		
	}

}
