import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1600 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int k, w, h;
	static char[][] map;
	static boolean[][][] visited;
	public static void main(String[] args) throws Exception{
		/*
		 * 원숭이 k번만 체스의 나이트처럼 움직일 수 있음
		 * 
		 * 격자판의 맨 왼쪽 위에서 시작해서 맨 오른쪽 아래까지 가야한다. 
		 * 인접한 네 방향으로 한 번 움직이는 것, 
		 * 말의 움직임으로 한 번 움직이는 것, 
		 * 모두 한 번의 동작으로 친다. 
		 * 격자판이 주어졌을 때, 
		 * 원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 방법을 알아내는 프로그램을 작성하시오.
		 * 
		 * 첫째 줄에 자연수 K가 주어진다. 
		 * 둘째 줄에 격자판의 가로길이 W, 
		 * 세로길이 H가 주어진다. 그 다음 H줄에 걸쳐 W개의 숫자가 주어지는데, 
		 * 0은 아무것도 없는 평지, 1은 장애물을 뜻한다. 장애물이 있는 곳으로는 이동할 수 없다. 
		 * 시작점과 도착점은 항상 평지이다. W와 H는 1이상 200이하의 자연수이고, K는 0이상 30이하의 정수이다.
		 * 
		 */
		
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new char[h][w];
		visited = new boolean[h][w][31];
		Node start = new Node(0, 0);
		Node end = new Node(h-1, w-1);
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
//			System.out.println(Arrays.toString(map[i]));
		}

		
		
		int move = run(k, start, end);
		
		System.out.println(move);
		
		
	}
	
	static int[] dx  = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[] jx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] jy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	private static int run(int count, Node start, Node end) {
		
		//원숭이는 count 만큼 나이트 점프를 할 수 있다.
		//매번 나이트 점프를 할 필요없이 한 칸으로 이동해도 된다.
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(new Node(start.x, start.y, 0));
//		System.out.println(queue.poll());
		visited[0][0][0] = true;
		int move = 0;
		int size = 0;
		while(!queue.isEmpty()) {
			
			size = queue.size();
//			System.out.println(size);
			for(int qsize=0; qsize<size; qsize++) {
				
				Node current = queue.poll();
//				System.out.println(current+" move :: "+move);
				if(current.x == end.x && current.y == end.y) {
					return move;
				}
				
				for(int i=0; i<4; i++) {
					int nx, ny;
					nx = current.x + dx[i];
					ny = current.y + dy[i];
					
					//방문 체크는 
					if(0 <= nx && nx < h && 0 <= ny && ny < w && !visited[nx][ny][current.jump] && map[nx][ny] =='0'){
						queue.add(new Node(nx, ny, current.jump));
						visited[nx][ny][current.jump] = true;
					}
				}

				
				for(int i=0; i<8 && current.jump < count; i++) {
					int nx, ny, nj;
					nx = current.x + jx[i];
					ny = current.y + jy[i];
					nj = current.jump + 1;
					
					if(0 <= nx && nx < h && 0 <= ny && ny < w && !visited[nx][ny][nj] && map[nx][ny] =='0')	{
						queue.add(new Node(nx, ny, nj));
						visited[nx][ny][nj] = true;
					}
				}
				
				
			}
			
			move++;
			
		}
		
		
		return -1;
	}

	static class Node{
		int x, y, jump;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.jump = count;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", jump=" + jump + "]";
		}
		
		
	}
}
