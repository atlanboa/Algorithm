package 백준;
//백준 17472 다리만들기

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17472 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] map;
	static boolean[][] visited;
	static int color;
	static int n, m;
	static int[][] graph;
	static PriorityQueue<Node> trunk;
	static int[] p;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		color = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bfs(i, j);
			}
		}

//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		// 그래프 만들어주고
		graph = new int[color][color];
		trunk = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				findGraph(i, j);
			}
		}

//		for (int i = 0; i < color; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}

		p = new int[color];
		makeSet();

		int sum = 0;

		int size = trunk.size();

//		for(int i=0; i<size; i++) {
//			Node temp = trunk.poll();
//			System.out.println(temp);
//		}

		for (int i = 0; i < size; i++) {
			if (allConnected()) {
				break;
			}

			Node temp = trunk.poll();
//			System.out.println(temp);
			int x = temp.x;
			int y = temp.y;

			if (findSet(x) != findSet(y)) {
				unionSet(x, y);
				sum += temp.weight;

			}
		}
		
		for(int i=1; i<color; i++) {
			findSet(i);
		}

		if (!allConnected()) {
			sum = -1;
		}

		System.out.println(sum);
	}

	private static boolean allConnected() {

		for (int i = 1; i < p.length - 1; i++) {
			if (p[i] != p[i + 1]) {
				return false;
			}
		}

		return true;
	}

	private static boolean unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (x == y) {
			return true;
		}
		p[y] = x;

		return false;

	}

	private static int findSet(int x) {
		if (x == p[x])
			return x;
		int idx = findSet(p[x]);
		p[x] = idx;
		return idx;
	}

	private static void makeSet() {
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}

	}

	static int[] dx = { 1, -1, 0, -0 };
	static int[] dy = { 0, -0, 1, -1 };

	private static void bfs(int x, int y) {
		if (map[x][y] == 0 || visited[x][y])
			return;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {

			Node temp = queue.poll();
			map[temp.x][temp.y] = color;
			for (int i = 0; i < 4; i++) {
				int nx, ny;
				nx = temp.x + dx[i];
				ny = temp.y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && map[nx][ny] != 0) {
					// 좌표안이고 방문안했으면 방문했다 체크해주고 큐에 넣어줌.
					visited[nx][ny] = true;
					queue.add(new Node(nx, ny));
				}

			}

		}
		// 섬 방문 끝나면 컬러 바꿔줌
		color++;

	}

	private static void findGraph(int x, int y) {
		if (!visited[x][y])
			return; // 방문 안했으면 다 재낌
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		visited[x][y] = false;// 방문체크를 반대로

		while (!queue.isEmpty()) {

			Node temp = queue.poll();
			// 현재 좌표에서 연결된 섬 찾기

			findIsland(temp.x, temp.y, map[x][y]);

			for (int i = 0; i < 4; i++) {
				int nx, ny;
				nx = temp.x + dx[i];
				ny = temp.y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && visited[nx][ny] && map[nx][ny] != 0) {
					// 좌표안이고 방문안했으면 방문했다 체크해주고 큐에 넣어줌.
					visited[nx][ny] = false;
					queue.add(new Node(nx, ny));
				}

			}

		}
		// 섬 방문 끝나면 컬러 바꿔줌

	}

	private static void findIsland(int x, int y, int start) {

		for (int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			int cnt = 0;
			while (true) {
				//
				// 한방향 탐색 시작 한 칸 움직일때마다 거리 cnt 증가

				nx = nx + dx[i];
				ny = ny + dy[i];
//				cnt++;

				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					// 범위 안의 좌표
					if (map[nx][ny] == 0) {
						cnt++;
					} else if (map[nx][ny] == start) {
						break;
					} else {
						if (cnt >= 2) {
							graph[start][map[nx][ny]] = cnt;
							graph[map[nx][ny]][start] = cnt;
							trunk.add(new Node(start, map[nx][ny], cnt));
						}

						break;
					}

//					if (map[nx][ny] == start)
//						break; // 같은 섬이면 다른 점 탐색
//					if (map[nx][ny] != 0) { // 같은 섬도 아니고 0도 아니면 다른 섬
//						// 시작섬부터 도착첨까지의 거리는 cnt이다.
//						// 반대도 동일
//						if (cnt >= 2) {
//
//							graph[start][map[nx][ny]] = cnt;
//							graph[map[nx][ny]][start] = cnt;
//							trunk.add(new Node(start, map[nx][ny], cnt));
//						}
//
//					}

				} else {// 범위밖이라면
					break;
				}

			}
		}

	}

	static class Node implements Comparable<Node> {
		int x, y, weight;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			weight = 0;
		}

		public Node(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return new Integer(weight).compareTo(new Integer(o.weight));
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}

	}
}