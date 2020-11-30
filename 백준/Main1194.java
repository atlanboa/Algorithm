package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Main1194
 * 
 * 
 * 빈 곳 : 언제나 이동할 수 있다. ('.‘로 표시됨) 벽 : 절대 이동할 수 없다. (‘#’) 열쇠 : 언제나 이동할 수 있다. 이 곳에
 * 처음 들어가면 열쇠를 집는다. (a - f) 문 : 대응하는 열쇠가 있을 때만 이동할 수 있다. (A - F) 민식이의 현재 위치 : 빈
 * 곳이고, 민식이가 현재 서 있는 곳이다. (숫자 0) 출구 : 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를
 * 탈출한다. (숫자 1)
 * 
 * 첫째 줄에 미로의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 50) 둘째 줄부터 N개의 줄에 미로의 모양이 주어진다.
 * 같은 타입의 열쇠가 여러 개 있을 수 있고, 문도 마찬가지이다. 그리고, 영식이가 열쇠를 숨겨놓는 다면 문에 대응하는 열쇠가 없을 수도
 * 있다. 0은 한 개, 1은 적어도 한 개 있다. 그리고, 열쇠는 여러 번 사용할 수 있다.
 * 
 * 최솟값 출력, 없으면 -1 5 5 ....1 #1### .1.#0 ....A .1.#.
 * 
 * 
a#c#eF.1
.#.#.#..
.#B#D###
0....F.1
C#E#A###
.#.#.#..
d#f#bF.1
 * 
 */
public class Main1194 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static char[][] map;
	static boolean[][][] visited;
	static int n, m;
	static Node minsik;

	public static void main(final String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		min = Integer.MAX_VALUE;
		visited = new boolean[n][m][1 << 6];
		// 0에서 시작, 0을 찾아줘야 합니다.
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					map[i][j] = '.';
					minsik = new Node(i, j, 0);
				}
			}
		}

		int move = bfs();

		System.out.println(move);

	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int min;

	private static int bfs() {
		final LinkedList<Node> queue = new LinkedList();
		queue.add(new Node(minsik.x, minsik.y, 0));
		visited[minsik.x][minsik.y][0] = true;
		int move = 0;
		// queue 에는 갈 수 있는 위치만 저장되어 있습니다.
		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int qsize = 0; qsize < size; qsize++) {

				Node cur = queue.poll();

				if (map[cur.x][cur.y] == '1') {
					return move;
				}

				for (int i = 0; i < 4; i++) {

					int nx, ny, key;
					nx = cur.x + dx[i];
					ny = cur.y + dy[i];
					key = cur.key;
					// 범위 안, 벽이 아니고, 키를 가지고 방문 해본 적 없는 경우
					if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] != '#' && !visited[nx][ny][cur.key]) {
						
						// 키 만나면 키 값 변경
						if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
							key = key | (1 << (map[nx][ny] - 'a'));
						} else if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
							// 현재 키로 문을 못 열면 패스
							if ((cur.key & (1 << (map[nx][ny] - 'A'))) == 0) {
								continue;
							}
						}
						
						queue.add(new Node(nx, ny, key));
						visited[nx][ny][cur.key] = true;

					}

				}

			}
			
			move++;

		}

		return -1;
	}

	// 키 보유를 어떻게 할까
	static class Node {
		int x, y, key;

		public Node(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}

	}

}