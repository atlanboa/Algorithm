package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution1953 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	/*
	 * 탈주범이 있을 수 있는 위치의 개수를 계산
	 * 탈주범은 시간당 1의 거리를 움직일 수 있다.
	 * 
	 * 지하터널의 종류는 7종류
	 * 1번 : 상하좌우
	 * 2번 : 상하
	 * 3번 : 좌우
	 * 4번 : 상우
	 * 5번 : 하우
	 * 6번 : 하좌
	 * 7번 : 상좌
	 * 
	 */
	static int[][] map;
	static int[][][] tunnel = {
			//1번
			{},
			{{-1, 1, 0, 0},{0, 0, 1, -1}},
			//2번
			{{-1, 1}, {0, 0}},
			//3번
			{{0, 0}, {-1, 1}},
			//4번
			{{-1, 0}, {0, 1}},
			//5번
			{{1, 0}, {0, 1}},
			//6번
			{{1, 0},{0, -1}},
			//7번
			{{-1, 0},{0, -1}}
			
	};
	static int N, M, R, C, L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			//N 세로 크기, 가로 크기 M, 맨홀 뚜껑 위치 (R,C), 탈출 시간 L
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			//다음 N줄에는 지하 터널 지도 정보, 각 줄마다 M개의 숫자
			map = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			
			//0은 터널이 없습니다.
			//bfs 도려서 탈주범이 있을 개수 출력
			int cnt = bfs(R, C);
			System.out.println("#"+t+" "+cnt);
		}
		

	}
	private static int bfs(int r, int c) {
		int cnt = 1;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c, 1));
		boolean[][] visited = new boolean[N][M];
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			//터널 종류
			int tunnelIdx = map[temp.x][temp.y];
			//터널이 총 몇방향 있냐
			int dir = tunnel[tunnelIdx][0].length;
//			System.out.println(dir);
			for(int i=0; i<dir; i++) {
				int nx, ny;
				nx = temp.x + tunnel[tunnelIdx][0][i];
				ny = temp.y + tunnel[tunnelIdx][1][i];
				
				//범위 밖 아웃, 0이면 아웃, 방문했으면 아웃
				if(0 > nx || nx >= N || 0 > ny || ny >= M 
						|| map[nx][ny]==0 || visited[nx][ny] || temp.t + 1 > L) {
					continue;
				}
				
				//다음 갈 파이프랑 현재 파이프랑 갈 수 있는 길인지 확인해야함..
				int nextTunnelIdx = map[nx][ny];
				int nDir = tunnel[nextTunnelIdx][0].length;
				boolean canGo = false;
				for(int j=0; j<nDir; j++) {
					int nnx, nny;
					nnx = nx + tunnel[nextTunnelIdx][0][j];
					nny = ny + tunnel[nextTunnelIdx][1][j];
					
					//좌표만 확인
					if(0 > nnx || nnx >= N || 0 > nny || nny >= M) {
						continue;
					}
					
					if(nnx == temp.x && nny == temp.y) {
						canGo = true;
						break;
					}
				}
				if(canGo) {
					System.out.println(new Node(nx, ny, temp.t+1));
					
					queue.add(new Node(nx, ny, temp.t+1));
					visited[nx][ny] = true;
					cnt++;
				}

				
			}

			
			
		}
		
		
		return cnt;
	}
	
	static class Node{
		int x, y, t;
		public Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", t=" + t + "]";
		}
	}
}
