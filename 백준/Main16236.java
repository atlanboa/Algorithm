package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main16236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		Node shark = null;
		LinkedList<Node> fishes = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Node(i, j, 2);
					map[i][j] = 0;
				} else if (map[i][j] >= 1) {
					fishes.add(new Node(i, j, map[i][j]));
				}

			}
		}

		/*
		 * 먹을 수 있는 물고기를 찾는다. 가능한 물고기가 있다..? 1. 없다면 엄마 상어에게 도움을 요청 2.기준은? 가까운 순서대로 ->
		 * 위쪽으로 -> 좌측으로 1. 1마리면? 바로 먹으러감 2. 여러마리면? 1. 가까운 순서대로 정렬 1. 위쪽과 왼쪽으로 가까운 순서로 정렬
		 */

		boolean[][] visited = new boolean[n][n];
		int time = 0;

		// 먹을 수 있는 물고기 찾는다.
		// bfs로 움직이면 제일 가까운 물고기 찾겠쪄.. 찾으면 찾은 좌표 기준으로 다시 bfs
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(shark.x, shark.y, shark.size));
		visited[shark.x][shark.y] = true;
		int nx, ny;
		int eat = 0;
		int cnt = 0;
		while (!queue.isEmpty()) {

			if (!isPromising(fishes, shark)) {
				// 남아있는 먹을수 잇는 물고기가 없으면?
				// call mom
				break;
			}

			int size = queue.size();

			int minx = n, miny = n;
			cnt++;
			for (int i = 0; i < size; i++) {

				Node temp = queue.poll();

				for (int j = 0; j < 4; j++) {
					nx = temp.x + dx[j];
					ny = temp.y + dy[j];

					if (0 <= nx && nx < n && 0 <= ny && ny < n 
							&& !visited[nx][ny] && map[nx][ny] <= shark.size) {
						// 좌표 안이고 방문하지 않았고 갈 수 있는 길이면?
						if (map[nx][ny] > 0 && map[nx][ny] < shark.size) {

							if (nx < minx) {
								minx = nx;
								miny = ny;
							} else {
								if (nx == minx) {
									if (ny < miny) {
										miny = ny;
									}
								}
							}

						}
						visited[nx][ny] = true;
						queue.add(new Node(nx, ny, 0));// shark의 좌표를 넣어줌
					}

				}
				
				
				
			} // for i
			if(minx != n) {
				Iterator<Node> it = fishes.iterator();
				Node temp2 = null;
				while (it.hasNext()) {
					temp2 = it.next();
					if (temp2.x == minx && temp2.y == miny) {
						it.remove();
					}
				}

				// 먹은 개수 증가 시켜주고
				eat++;
				// 더 이상 지도상에 존재하는 물고기가 아님을 표시
				map[minx][miny] = 0;

				// 먹은 개수가 상어의 크기와 같아지면
				if (eat >= shark.size) {
					// 상어의 사이즈를 키워준다.
					eat = 0;
					shark.size++;
				}

				// 하나 먹었으니깐 마지막 물고기 먹은 위치에서 상어가 다시 시작
				queue.clear();
				for (int r = 0; r < n; r++) {
					Arrays.fill(visited[r], false);
				}

				shark.x = minx;
				shark.y = miny;

				visited[minx][miny] = true;
				queue.add(new Node(minx, miny, 0));
				
				time += cnt;
				cnt = 0;

			}
			

		}
		System.out.println(time);
		// 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간?

	}

	private static boolean isPromising(LinkedList<Node> fishes, Node shark) {

		Iterator<Node> it = fishes.iterator();
		boolean flag = false;
		for (Node t : fishes) {
			if (t.size < shark.size) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	static int[] dx = { 1, 0, 0, -1 };
	static int[] dy = { 0, -1, 1, 0 };

	static class Node {
		int x, y;
		int size;

		public Node(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

	}
}
