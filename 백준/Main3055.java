package 백준;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main3055 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static char[][] map;
	static Node d;
	static Node s;
	static Node w;
	static int r, c;
	static boolean[][] visited;
	static LinkedList<Node> queueA = new LinkedList<>();
	static LinkedList<Node> queueB = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];

		// 비버의 굴 위치
		d = new Node();
		// 출발 위치
		s = new Node();
		// 물의 위치
		w = new Node();

		visited = new boolean[r][c];
		
		queueA.clear();
		queueB.clear();
		
		for (int i = 0; i < r; i++) {
			
			map[i] = br.readLine().toCharArray();
			
			for (int j = 0; j < c; j++) {
				
				if (map[i][j] == 'D') {
					d.x = i;
					d.y = j;
				} else if (map[i][j] == 'S') {
					s.x = i;
					s.y = j;
				} else if (map[i][j] == '*') {
					queueA.add(new Node(i, j));
					visited[i][j] = true;
				}else if (map[i][j] == 'X') {
					visited[i][j] = true;
					
				}
			}
		}

		int time = run();
		
		
		if(time == 0) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(time);
		}

	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	private static int run() {
		
		queueB.add(new Node(s.x, s.y));
		
		visited[s.x][s.y] = true;
		

		
		int time = 0;
		
		
		
		while (!queueA.isEmpty() || !queueB.isEmpty()) {
			
			// 물 먼저 퍼지고 돌에는 퍼질수 없땅
			
			int size = queueA.size();
			for (int i = 0; i < size; i++) {
				Node water = queueA.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = water.x + dx[j];
					int ny = water.y + dy[j];
					
					//nx, ny가 범위안에 있고, 방문되지 않았으며(물이 퍼졌거나 돌이거나 동굴이 아닌 경우)
					//물을 퍼트리고 물로 표시해준다.
					if(0 <= nx && nx < r && 0 <= ny && ny < c && !visited[nx][ny]) {
						if(nx == d.x && ny == d.y) continue;
						visited[nx][ny] = true;
						queueA.add(new Node(nx, ny));
						
						
					}		
				}
			}

//			for(int i=0; i<r; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			

			
			// 고슴도치 이동
			size = queueB.size();
			for (int i = 0; i < size; i++) {
				Node beaver = queueB.poll();
				if(beaver.x == d.x && beaver.y == d.y) {
					return time;
				}
				
				
				for (int j = 0; j < 4; j++) {
					int nx = beaver.x + dx[j];
					int ny = beaver.y + dy[j];
					
					//이동할 좌표가 범위 내의 좌표이고 돌이 아니고 물이 아닌 경우
					if(0 <= nx && nx < r && 0 <= ny && ny < c &&
							!visited[nx][ny]) {						
						visited[nx][ny] = true;
						queueB.add(new Node(nx, ny));
						
					}		
				}
			}
			
			time++;
//			for(int i=0; i<r; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
		}//while
		return 0;
	}

	static class Node {
		int x;
		int y;

		public Node() {

		}

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}

}
