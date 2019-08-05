
import java.util.ArrayList;
import java.util.LinkedList;

public class BFS2 {
	static boolean[] visited = new boolean[9];
	static int[][] graph = new int[9][9];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		graph[0][1] = 1;
		graph[0][2] = 1;
		graph[0][3] = 1;
		
		graph[1][4] = 1;
		graph[1][5] = 1;
		
		graph[3][6] = 1;
		graph[3][7] = 1;
		graph[3][8] = 1;
		
		
		bfs(0);
	}

	private static void bfs(int index) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(index);
		
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			visited[temp] = true;
			System.out.println((char)(temp+65));
			
			
			for(int i=0; i<graph.length; i++) {
				if(graph[temp][i] == 1 && !visited[i]) {
						queue.add(i);
				}
			}
		}
		
		
	}
	
//	Wrapper class boolean -> Boolean, float -> Float, char-> Character
	void aa() {
		int a = 10;
		
//		Integer il = new Integer(a); //Boxing
		Integer il = a; // Auto UnBoxing을 제공 java 5.0 이후
		bb(il);
//		int b = il.intValue(); //UnBoxing
		
		bb(a);
	}

private void bb(Integer a) {
	// TODO Auto-generated method stub
	
}

}
