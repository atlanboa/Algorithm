import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution7396 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			
			st = new StringTokenizer(br.readLine());
			int N,M;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[N][M];
			
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				map[i] = line.toCharArray();
				System.out.println(Arrays.toString(map[i]));
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			LinkedList<Node> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			String result = ""+map[0][0];
			
			queue.add(new Node(0, 0, map[0][0]));
			visited[0][0] = true;
			out: while(!queue.isEmpty()) {
				
				
				pq.clear();
				int size = queue.size();
				System.out.println(size);
				for(int j=0; j<size; j++) {
					
					Node temp = queue.poll();
					if(temp.x == N-1 && temp.y == M-1) break out;
//					System.out.println("temp1 : "+temp);
//					result += temp.alpha+"";
					//하나 가져오고
					for(int i=0; i<2; i++) {
						int nx, ny;
						nx = temp.x + dx[i];
						ny = temp.y + dy[i];
						
						if(0 <= nx && nx < N && 0 <= ny && ny < M &&!visited[nx][ny]) {
							visited[nx][ny] = true;
							Node tempPQ =new Node(nx, ny, map[nx][ny]);
//							System.out.println(tempPQ);
							pq.add(tempPQ);
						}
					}
//					Node temp2 = pq.poll();
//					System.out.println("temp2 : "+temp2);
					
					
				}
				Node tempQ = pq.poll();
				Node next = null;
				queue.add(tempQ);
				
				result += tempQ.alpha+"";
				
				while(!pq.isEmpty()) {
					next = pq.poll();
					if(tempQ.alpha == next.alpha) {
						queue.add(next);
					}else {
						break;
					}
				}
				
				
				
				
				
				
			}
			System.out.println(result);
			
		}
	}
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	
	static class Node implements Comparable<Node>{
		int x, y;
		char alpha;
		
		public Node(int x, int y, char a) {
			this.x = x;
			this.y = y;
			this.alpha = a;
		}

		@Override
		public int compareTo(Node o) {
			return new Character(alpha).compareTo(new Character(o.alpha));
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", alpha=" + alpha + "]";
		}
		
	}

}
