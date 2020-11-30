package 백준;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main16235 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static LinkedList<Tree> queue = new LinkedList<>();
	static LinkedList<Tree> die = new LinkedList<>();
	static LinkedList<Tree> breeding = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N, M, K;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] s2d2 = new int[N+1][N+1];
		int[][] map = new int[N + 1][N + 1];
		// 양분 정보를 가지고 있는 지도

		
		queue.clear();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				s2d2[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}

		int x, y, age;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			age = Integer.parseInt(st.nextToken());

			queue.add(new Tree(x, y, age));
//			if (queue.isEmpty()) {
//				queue.add(new Tree(x, y, age));
//			} else {
//				for (int q = 0; q < queue.size(); q++) {
//					if (queue.get(q).age >= age) {
//						queue.add(q, new Tree(x, y, age));
//						break;
//					}
//				}
//			}

		}

		
		int year = 0;
		while (year < K) {

			//봄
			
//			die.clear();
			
			//봄
			for(Tree temp: queue) {
				if (map[temp.x][temp.y] >= temp.age) {
					map[temp.x][temp.y] -= temp.age;
					// 나무의 나이만큼 양분을 먹는다.
					temp.age++;
					// 양분을 먹은 나무는 나이가 증가한다.
					
				} else {

					temp.alive = false;
				}
			}
			
			//여름
			Iterator<Tree> it = queue.iterator();
			Tree temp1;
			while(it.hasNext()) {
				temp1 = it.next();
				if(!temp1.alive) {
					map[temp1.x][temp1.y] += temp1.age / 2;
					it.remove();	
				}
				
				
			}
			
			// queue는 오름차순 정렬
			
			breeding.clear();
			//가을
			int nx, ny; 
			for(Tree temp: queue) {
				if (temp.age % 5 == 0) {
					// 나이가 5의 배수이면 번식
					
					for (int j = 0; j < 8; j++) {
						
						nx = temp.x + dx[j];
						ny = temp.y + dy[j];

						if (1 <= nx && nx <= N && 1 <= ny && ny <= N) {
							breeding.add(0, new Tree(nx, ny, 1));
						}

					}
					
				}
			}
			
			
			queue.addAll(0, breeding);
	
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					map[i][j] += s2d2[i][j];
				}
			}
			

			year++;
		}//while

		System.out.println(queue.size());

	}

	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static class Tree{
		int x, y, age;
		boolean alive;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
			alive = true;
		}

		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", age=" + age + ", alive=" + alive + "]";
		}
		
	}
}
