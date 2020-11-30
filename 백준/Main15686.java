package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15686 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	/*
	 * 도시는 N x N 각 칸은 빈 칸, 치킨집, 집 중 하나 r, c는 1부터 시작 치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리 도시의
	 * 치킨 거리 : 모든 집의 치킨 거리의 합 두 칸의 거리는|r1 - r2| + |c1 - c2|
	 */

	static int[][] map;
	static int N, M;
	static ArrayList<Node> home;
	static ArrayList<Node> chicken;
	static int size;
	static int minDistance;
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());

		// 50 >= N >= 2 , 13 >= M >= 1
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		// N개의 줄의 도시 정보
		// 0, 1, 2 0 빈칸, 1은 집, 2는 치킨집
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					home.add(new Node(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}

			}
		}
		
//		for(int i=0; i<home.size(); i++) {
//			System.out.println(home.get(i));
//		}
//		for(int i=0; i<chicken.size(); i++) {
//			System.out.println(chicken.get(i));
//		}
		
		minDistance = Integer.MAX_VALUE;
		size = chicken.size();
		boolean[] visited = new boolean[size];
		
		dfs(visited, 0, 0);
		
		System.out.println(minDistance);

		
	}


	private static void dfs(boolean[] visited, int depth, int index) {
		
		if(depth == M) {
//			System.out.println("들어오긴하니");
			int sum = 0;
			for(int i=0; i<home.size(); i++) {
				int min = Integer.MAX_VALUE;
				Node h = home.get(i);
				for(int j=0; j<size; j++) {
					if(visited[j]) {
						Node c = chicken.get(j);
						int dis = Math.abs(h.x-c.x)+Math.abs(h.y-c.y);
						if(min > dis) min = dis;	
					}
				}
				sum += min;
//				System.out.println(min);
			}
			
			if(minDistance > sum) {
				minDistance = sum;
			}
			
			return;
		}
		
	
		
			
		for(int i=index; i<size; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(visited, depth+1, i+1);
				visited[i] = false;	
				
			}
			
		}
		
		
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
