package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main16985 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	/*
	 * 5 x 5 판 5개
	 */

	static char[][][][] maze;

	public static void main(String[] args) throws NumberFormatException, IOException {
		maze = new char[5][4][5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				char[] line = br.readLine().replace(" ", "").toCharArray();

				for (int k = 0; k < 5; k++) {

					maze[i][0][j][k] = line[k];
					maze[i][1][k][4 - j] = line[k];
					maze[i][2][4 - j][4 - k] = line[k];
					maze[i][3][4 - k][j] = line[k];

				}

			}
		}

		/*
		 * 각 층에서 한판씩 선택해서 순서를 바꿉니다. 제일 위층이나 제일 아래층이 꼭지점이 없으면 잘못된 케이스로 패스 제일 위층의 입구와 제일
		 * 아래층의 출구는 면을 공유하지 않습니다. 가장 적은 횟수로 탈출할 수 있는 케이스의 이동 횟수를 출력
		 */

		// 1. 선택하는 경우의 수를 뽑음.
		min = Integer.MAX_VALUE;
		cnt = 0;
		getCases();
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

	private static void getCases() {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					for (int l = 0; l < 4; l++) {
						for (int r = 0; r < 4; r++) {

							// (0,i), (1,j), (2,k), (3,l),(4,r)
							// 5판을 선택하는데 이거마저도 순서가 바뀔수 있져
							int[][] cube = { { 0, i }, { 1, j }, { 2, k }, { 3, l }, { 4, r } };
							permutation(cube, 0);

						}
					}
				}
			}
		}

	}
	static int cnt;
	private static void permutation(int[][] cube, int depth) {
		if (depth == 5) {
//			cnt++;
//			if(cnt >= 5) return;
			char[][][] customCube = new char[5][5][5];
			// customCube 만들어주고
//			for(int i=0; i<5; i++) {
//				System.out.println(Arrays.toString(cube[i]));
//			}System.out.println();
			
			for (int i = 0; i < 5; i++) {
				customCube[i] = maze[cube[i][0]][cube[i][1]];
//				for(int j=0; j<5; j++) {
//					System.out.println(Arrays.toString( maze[cube[i][0]][cube[i][1]][j]));
//				}System.out.println();
				
			}
//			System.out.println("---------------------");


			
			ArrayList<Node> enter = new ArrayList<>();
			ArrayList<Node> out = new ArrayList<>();

			Node[] vertexes = new Node[4];
			vertexes[0] = new Node(0, 0);
			vertexes[1] = new Node(0, 4);
			vertexes[2] = new Node(4, 0);
			vertexes[3] = new Node(4, 4);
			// 입구 출구 체크

			for (int i = 0; i < 4; i++) {
				if (customCube[0][vertexes[i].x][vertexes[i].y] == '1') {
					enter.add(new Node(vertexes[i].x, vertexes[i].y));
				}
				if (customCube[4][vertexes[i].x][vertexes[i].y] == '1') {
					out.add(new Node(vertexes[i].x, vertexes[i].y));
				}
			}

			for (int i = 0; i < enter.size(); i++) {
				for (int j = 0; j < out.size(); j++) {
					Node e = enter.get(i);
					Node o = out.get(j);

					if (e.x == o.x || e.y == o.y) {
						continue;
					}
//					System.out.println(e+" "+o);
					bfs(customCube, new Pos(0, e.x, e.y, 0), new Pos(4, o.x, o.y, 0));
//					System.out.println("체크");
				}
			}

			// 큐브 탐색 시작

			return;
		}

		for (int i = depth; i < 5; i++) {
			swap(cube, depth, i);
			permutation(cube, depth + 1);
			swap(cube, depth, i);
		}

	}
	static int  min;
	private static void bfs(char[][][] customCube, Pos e, Pos o) {
		// 상
		int[] dl = { -1, 1, 0, 0, 0, 0 };
		int[] dx = { 0, 0, 1, -1, 0, 0 };
		int[] dy = { 0, 0, 0, 0, 1, -1 };

		// e 시작 좌표, o 출구 좌표
		boolean[][][] visited = new boolean[5][5][5];
		LinkedList<Pos> queue = new LinkedList<>();
		queue.add(new Pos(e.l, e.x, e.y, 0));
		visited[e.l][e.x][e.y] = true;
		
		
		while (!queue.isEmpty()) {

			Pos temp = queue.poll();
			int nl, nx, ny, nMove;
			nMove = temp.move+1;
//			System.out.println(temp);
			for (int i = 0; i < 6; i++) {
				
				nl = temp.l + dl[i];
				nx = temp.x + dx[i];
				ny = temp.y + dy[i];
				
				// 좌표 아웃, 방문 불가, 이미 방문한 좌표, 최소 움직임보다 클때
				if (0 > nl || nl >= 5 || 0 > nx || nx >= 5 || 0 > ny || ny >= 5 
					|| customCube[nl][nx][ny] == '0' 
					|| visited[nl][nx][ny] 
					|| min <= nMove) {
					continue;
				}
				
				//가지치기 끝났으면 조건 체크 해봅미다잉
				//도착했는가?
				if(nl == o.l && nx == o.x && ny == o.y) {
					System.out.println("도착");
					if(min > nMove) {
						min = nMove;
//						System.out.println(e+" "+o+" "+temp);
//						System.out.println("갱신");
//						printCube(customCube);
					}
					return;
				}
				
				queue.add(new Pos(nl, nx, ny, nMove));
				visited[nl][nx][ny] = true;

			}

		}

	}

	private static void printCube(char[][][] customCube) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.println(Arrays.toString(customCube[i][j]));
			}System.out.println();
		}
		
	}

	private static void swap(int[][] cube, int depth, int i) {
		int[] temp = cube[depth];
		cube[depth] = cube[i];
		cube[i] = temp;
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

	static class Pos {
		int l, x, y, move;

		public Pos(int l, int x, int y, int move) {
			this.l = l;
			this.x = x;
			this.y = y;
			this.move = move;
		}

		@Override
		public String toString() {
			return "Pos [l=" + l + ", x=" + x + ", y=" + y + ", move=" + move + "]";
		}
		
		
	}
}