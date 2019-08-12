import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//1082 : 화염에서탈출 bfs
public class Jungol1082 {
	static boolean[][] visited;
	static int r, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		Node start = new Node();
		
	
		Node destination = new Node();

		char[][] map = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				

				if (map[i][j] == 'S') {
					// 시작 좌표
					start.x = i;
					start.y = j;
					
				} else if (map[i][j] == '*') {
					// 화염 시작 좌표
					f.add(new Node(i, j));
					visited[i][j] = true;

				} else if (map[i][j] == 'D') {
					// 도착 좌표
					destination.x = i;
					destination.y = j;
				} else if (map[i][j] == 'X') {
					visited[i][j] = true;
				}

			}

		}
		
		
		
		int result = escape(start, destination);
		if(result == 0) {
			System.out.println("impossible");
		}else {
			System.out.println(result);
		}
		

	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static LinkedList<Node> f = new LinkedList<>();
	private static int escape(Node start, Node destination) {
		LinkedList<Node> user = new LinkedList<>();
		

		user.add(new Node(start.x, start.y));

		visited[start.x][start.y] = true;
		
		
		int level = 0;
		
		while (!user.isEmpty() || !f.isEmpty()) {
			


			int userSize = user.size();
			int fSize = f.size();
			
			for(int i=0; i<fSize; i++) {
				
				
				Node fTemp = f.poll();
				
				for(int j=0; j<4; j++) {
					
					int nx = fTemp.x + dx[j];
					int ny = fTemp.y + dy[j];
					
					if( 0 <= nx && nx < r && 0 <= ny && ny < c && !visited[nx][ny]
							) {
						if(nx == destination.x && ny == destination.y) {
							continue;
						}
						visited[nx][ny] = true;
						f.add(new Node(nx, ny));
					}
				}
				
				
			}
			
			for(int i=0; i<userSize; i++) {
				
				Node userTemp = user.poll();
				if(userTemp.x == destination.x && userTemp.y == destination.y) {
					
					return level;
					
				}
			
			
				for(int j=0; j<4; j++) {
					
					int nx = userTemp.x + dx[j];
					int ny = userTemp.y + dy[j];
					
					if( 0 <= nx && nx < r && 0 <= ny && ny < c && !visited[nx][ny]) {

						visited[nx][ny] = true;
						
						user.add(new Node(nx, ny));
					}
				}
				
			}
			

			
			level++;
			
			
			
			
		} 
		return 0;
	}

	static class Node {
		int x;
		int y;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
