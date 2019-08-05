
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Graph graph = new Graph(10);
		graph.addAdj(1, 2);
		graph.addAdj(1, 3);
		graph.addAdj(1, 4);
	
		
		
		
		graph.addAdj(2, 5);
		graph.addAdj(2, 6);
		
		graph.addAdj(4, 7);
		graph.addAdj(4, 8);
		graph.addAdj(4, 9);
//		print(graph);
//		bfs(0);
		graph.bfs(1);
		
		
	}


	static boolean[] visited = new boolean[9];

	static class Graph{
		int ver;
		Queue<Integer>[] adj = null;
		public Graph(int ver){
			this.ver = ver;
			adj = new LinkedList[ver];
			for(int i=0; i<adj.length; i++) {
				adj[i] = new LinkedList();
			}

		}
		public void addAdj(int x, int y) {
			adj[x].offer(y);
			
		}
		
		void bfs(int start) {
			//큐, 방문체크 배열
			boolean[] visited = new boolean[ver];
			Queue<Integer> q = new LinkedList<>();
			q.offer(start);
			int level = 0;
			
			while(!q.isEmpty()) {
				System.out.print("level : "+level+" ");
				int qSize = q.size();
				for(int i=0; i<qSize; i++) {
					int idx = q.poll();
					System.out.print((char)(idx+64)+" ");
					visited[idx] = true;
					
					Iterator<Integer> list = adj[idx].iterator();
					while(list.hasNext()) {
						idx = list.next();
						if(!visited[idx]) {
							q.offer(idx);	
						}
						
					}
				}
				level++;
				System.out.println();
				
				
				
			}
			
			
			
		}
	}
	
}	