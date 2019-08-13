import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DfsBfs {
	static int n, m, v;
	static boolean[] visited = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		Graph graph = new Graph(n+1);
		
		
		for(int i=0; i<m; i++) {
			int x, y;
			x = sc.nextInt();
			y = sc.nextInt();
			graph.insert(x, y);
			graph.insert(y, x);
		}
		visited = new boolean[n+1];
		graph.dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		graph.bfs(v);
	}

	static class Graph{

		LinkedList<Integer>[] list = null;
		Stack<Integer> stack = null;
		Queue<Integer> queue = null;
		
		
		
		public Graph(int vertex) {
			queue = new LinkedList<>();
			list = new LinkedList[vertex];
			for(int i=0; i<list.length; i++) {
				list[i] = new LinkedList<>();
			}

			stack = new Stack<>();
			
		}
		
		
		void insert(int vertex1, int vertex2) {
			list[vertex1].offer(vertex2);
//			System.out.println(vertex1+" "+vertex2);
		}
		
		void dfs(int ver) {
			//종료 조건
			System.out.print(ver+" ");
			stack.push(ver);
			visited[ver] = true;
			//더 이상 갈 자식이 없으면
			if(list[ver].size()==0) {
				stack.pop();
				return ;
				
			}
			//모든 정점을 방문한 상태일때
			if(stack.isEmpty()) return ;
			list[ver].sort(null);
			Iterator<Integer> it = list[ver].iterator();
			
			while(it.hasNext()) {
				int idx = it.next();
//				System.out.println(idx);
				if(!visited[idx]) {
					dfs(idx);
					
				}
				
			}
				

			
		}
		
		
		void bfs(int ver) {

			queue.offer(ver);
			while(!queue.isEmpty()) {
				
				int temp = queue.poll();
				if(!visited[temp]) System.out.print(temp+" ");
				visited[temp]=true;	
				
				
				list[temp].sort(null);
				Iterator<Integer> it = list[temp].iterator();
				
				while(it.hasNext()) {
					int idx = it.next();
					if(!visited[idx]) {
						queue.offer(idx);
					}
				}
				
				
			}
			
			
			
			
			
			
			
		}
		
		
	}
}
