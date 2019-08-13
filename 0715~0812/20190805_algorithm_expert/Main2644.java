import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2644 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		Graph graph = new Graph(n+1);
		
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int tx = sc.nextInt();
			int ty = sc.nextInt();
			graph.insert(tx, ty);
			graph.insert(ty, tx);
		}
		
		System.out.println(graph.bfs(x, y));
		
	}
	
	static class Graph{
		LinkedList[] list = null;
		
		public Graph(int n) {
			list = new LinkedList[n];
			for(int i=0; i<list.length; i++) {
				list[i] = new LinkedList<Integer>();
			}
		}
		
		public int bfs(int x, int y) {
			LinkedList<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[list.length];
			q.offer(x);
			visited[x] = true;
			int level = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i=0; i<size; i++) {
					int temp = q.poll();
					if(temp==y) return level;
					Iterator<Integer> it = list[temp].iterator();
					
					while(it.hasNext()) {
						int idx= it.next();
						if(!visited[idx]) {
							q.offer(idx);
							visited[idx] = true;
						}
					}
					
					
				}
				
				level++;
				
				
			}
			
			return -1;
		}

		void insert(int x, int y) {
			list[x].offer(y);
		}
	}

}