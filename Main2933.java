import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2933 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static char[][] map;
	static int R, C;;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		int T = Integer.parseInt(br.readLine());
		down = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int fireCnt = Integer.parseInt(br.readLine());
		int[] fire = new int[fireCnt];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < fireCnt; i++) {
			fire[i] = Integer.parseInt(st.nextToken());
		}

		boolean left = true;
		for (int i = 0; i < fireCnt; i++) {
//			printMap();
			int height = R - fire[i];

			if (left) {
				left = false;
				for (int j = 0; j < C; j++) {
					if (map[height][j] == 'x') {
						map[height][j] = '.';
//						printMap();
						findCluster(height, j);
						break;
					}
				}//10 4 9 2 8 2 7 1 7 1 7 5 7 3 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7
			} else {
				left = true;
				for (int j = C - 1; j >= 0; j--) {
					if (map[height][j] == 'x') {
						map[height][j] = '.';
//						printMap();
						findCluster(height, j);
						break;
					}
				}
			}

		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	private static void findCluster(int x, int y) {
		int nx, ny, min;
		min = Integer.MAX_VALUE;
		
		visited = new boolean[R][C];
		for (int i = 0; i < 4; i++) {
			cluster = new int[R][C];
			nx = x + dx[i];
			ny = y + dy[i];
			if (0 <= nx && nx < R && 0 <= ny && ny < C && map[nx][ny] == 'x' && !visited[nx][ny]) {
				down.clear();
				boolean flag = bfs(nx, ny);
				if (flag) {
//					int drop = down.get(down.size()-1).x;
//					System.out.println("drop: "+drop);
					for(int j=0; j<down.size(); j++) {
						Node temp = down.get(j);
						map[temp.x][temp.y] = '.';
						cluster[temp.x][temp.y] = 1;
					}
					int drop = 0;
					
					for(int j=0; j<down.size(); j++) {
						Node temp = down.get(j);
						drop = getDrop(temp);
						if(min > drop) min = drop;
					}
					
					
					for(int j=0; j<down.size(); j++) {
						Node temp = down.get(j);
						map[temp.x + min][temp.y] = 'x';
					}

				}
			}
		}

	}

	static boolean[][] visited;
	static int[][] cluster;
	static ArrayList<Node> down;

	private static boolean bfs(int nx, int ny) {
		boolean flag = true;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(nx, ny));
		boolean[][] visited = new boolean[R][C];
		visited[nx][ny] = true;
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			down.add(new Node(temp.x, temp.y));
			if (temp.x == R - 1)
				flag = false;
			
//			if(temp.x + 1< R && map[temp.x+1][temp.y] =='.') {
//				int drop = getDrop(temp);
//				if(min > drop) min = drop;
//			}

			for (int i = 0; i < 4; i++) {
				nx = temp.x + dx[i];
				ny = temp.y + dy[i];
				if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny] && map[nx][ny] == 'x') {
					queue.add(new Node(nx, ny));
					visited[nx][ny] = true;
				}

			}

		}
//		down.add(new Node(min, min));
		return flag;

	}

	private static int getDrop(Node temp) {

		int cnt = 0;
		for (int i = temp.x+1; i < R; i++) {
			if (map[i][temp.y] == '.') {
				cnt++;
			} else {
				if(cluster[i][temp.y]==1) {
					cnt = 0;
					continue;
				}else {
					break;
				}
			}

		}

		return cnt;
	}

	private static void printCluster() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(cluster[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void printMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}
}
