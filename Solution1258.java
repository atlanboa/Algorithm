import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n+1][n+1];
			
			LinkedList<Node> xy = new LinkedList<>();
			PriorityQueue<Node> subMat = new PriorityQueue<>();
			
			for(int i=1; i<map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<map.length; j++) {
					
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0 && map[i-1][j]==0 && map[i][j-1]==0) {
//						System.out.println(i+" "+j);
						xy.add(new Node(i, j));
					}
				}
			}
			

			int size = xy.size();
			for(int i=0; i<size; i++) {
				
				Node temp = chk(xy.poll(), map);
//				System.out.println("x : "+temp.x+" y : "+temp.y);
				subMat.add(temp);
	
				
			}
//			System.out.println();
			

			size = subMat.size();
			System.out.print("#"+t+" "+size+" ");
			for(int i=0; i<size; i++) {
				
				Node temp = subMat.poll();
				System.out.print(temp.x+" "+temp.y+" ");
	
			}
			System.out.println();
		}

	}
	private static Node chk(Node poll, int[][] map) {
		
		int x = 0;
		int y = 0;
		
		for(int i=poll.x; i<map.length; i++) {
			if(map[i][poll.y] == 0) break;
			x++;
			
		}
		
		for(int i=poll.y; i<map.length; i++) {
			if(map[poll.x][i]==0) break;
			y++;
			
		}
		
		
		
		
		return new Node(x, y);
	}
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int weight;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			weight = x*y;
		}
		@Override
		public int compareTo(Node o) {
			
			if(o.weight > weight) {
				return -1;
			}else {
				if(o.weight == weight) {
					return o.x > x? -1:1;
				}else {
					return 1;
				}
			}
			
			
			
		}
	}

}
