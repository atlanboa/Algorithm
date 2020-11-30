package SW아카데미;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution2805 {
	static int[][] farm;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T; t++) {
			int n = sc.nextInt();
			farm = new int[n][n];
			visited = new boolean[n][n];
			int sum = 0;
			
			for(int i=0; i<farm.length; i++) {
				String temp = sc.next();
				for(int j=0; j<farm.length;j++) {
					farm[i][j] = temp.charAt(j)-'0';
					
				}
				
			}
			
			System.out.println("#"+t+" "+(BFS(n/2, n/2)));
			
			
		}
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static int BFS(int x, int y) {
		int sum = 0;
		int cnt = farm.length/2;
		LinkedList<Cdn> queue = new LinkedList<>();
		queue.add(new Cdn(x,y));
		sum += farm[x][y];
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			if(cnt == 0) break;
			cnt--;
			for(int i=0; i<size; i++) {
				Cdn temp = queue.poll();	
				for(int j=0; j<4; j++) {
					int tx = temp.x + dx[j];
					int ty = temp.y + dy[j];
					
					if(!visited[tx][ty]) {
						queue.add(new Cdn(tx, ty));
						visited[tx][ty] = true;
						sum += farm[tx][ty];
						
					}
				}	
			}
			
		}
		
		return sum;
	}
	
	static class Cdn{
		int x;
		int y;
		
		public Cdn(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}
	
	
	
	
	
}
