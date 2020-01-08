import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main3197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int r, c;
	static char[][] map;
	static int[][] meltedDay;
	static Node[] swan;
	static int swanIndex;
	public static void main(String[] args) throws Exception{
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		meltedDay = new int[r][c];
		swan = new Node[2];
		swanIndex = 0;
		
		for(int i=0; i<r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int left, right, min;
		left=0; right = melting(); min = Integer.MAX_VALUE;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			boolean found = run(mid);
			
			if(!found) {
				left = mid + 1;
			}else {
				if(min > mid) min = mid;
				right = mid -1;
			}
			
		}
		
		System.out.println(min);
//		System.out.println(max);
//		for(int i=0; i<r; i++) {
//			System.out.println(Arrays.toString(meltedDay[i]));
//		}
		
		
		
		
		
//		run();
		
	}
//	private static void makeSet() {
//		for(int i=0; i<p.length; i++) {
//			p[i] = i;
//		}
//	}
//	
//	private static void unionSet(int x, int y) {
//		x = findSet(x);
//		y = findSet(y);
//		
//		if(x == y) return;
//		p[x] = y;
//	}
//	private static int findSet(int x) {
//		
//		if(x==p[x]) return x;
//		int idx = findSet(p[x]);
//		p[x] = idx;
//		return idx;
//	}

	private static boolean run(int mid) {

		boolean[][] visited = new boolean[r][c];
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(new Node(swan[0].x, swan[0].y));
		visited[swan[0].x][swan[0].y] = true;
		
		while(!queue.isEmpty()) {
			
			Node cur = queue.poll();
			
			if(cur.x == swan[1].x && cur.y == swan[1].y) return true;
			
			for(int i=0; i<4; i++) {
				int nx , ny;
				
				nx = cur.x + dx[i];
				ny = cur.y  + dy[i];
				
				if(0 <= nx && nx < r && 0 <= ny && ny < c && !visited[nx][ny]&& meltedDay[nx][ny] <= mid) {
					queue.add(new Node(nx, ny));
					visited[nx][ny] = true;
				}
				
				
			}
			
		}
		
		
		return false;
	}

	private static int melting() {
		// TODO Auto-generated method stub
		
		boolean[][] visited = new boolean[r][c];
		LinkedList<Node> queue = new LinkedList<Node>();
		int hours = 1;
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j] == '.' || map[i][j] == 'L') {
					if(map[i][j] == 'L') swan[swanIndex++] = new Node(i, j);
					queue.add(new Node(i, j));
					visited[i][j] = true;
				}
			}
		}

		int max = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int qsize=0; qsize<size; qsize++) {
				Node cur = queue.poll();
				
				for(int dir=0; dir<4; dir++) {
					
					int nx, ny;
					nx = cur.x + dx[dir];
					ny = cur.y + dy[dir];
					
					if(0 <= nx && nx < r && 0 <= ny && ny < c && !visited[nx][ny] && map[nx][ny] != 'L') {
						meltedDay[nx][ny] = hours;
						if(max < meltedDay[nx][ny]) max =meltedDay[nx][ny]; 
						visited[nx][ny] = true;
						queue.add(new Node(nx, ny));
					}
					
					
				}
				
			}
			
			hours++;
				
			
			
		}

		
		
		return max;
		
	}

	/*
	 * '1' 은 int 로 49
	 * 
	 * bfs 한번 돌림
	 * 입력받을때 물덩이를 다 숫자로 바꿔줌
	 * 숫자로 바꾸면서 백조 있으면 백조 그룹 확인해줌
	 * 총 물덩이 개수만큼 1차원 배열 생성
	 * 자기 자신을 가리키도록 초기화
	 * bfs 돌리고
	 * 물덩이가 만날때마다 unionset 해줌
	 * bfs 한번 끝날때마다 두 백조가 속한 부모가 같은지 체크해줌
	 * 다르면 한번 더 돌림
	 * 물덩이 각각을 그룹으로 지정
	 * 그룹이 만나면 그룹을 뭉쳐줌
	 * 
	 */
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0,1, -1};
	
//	
//	private static boolean initGroup(char index, int x, int y) {
//
//		if(map[x][y] != '.') return false;
//		
//		LinkedList<Node> queue = new LinkedList<Node>();
//		queue.add(new Node(x, y));
//		
//		while(!queue.isEmpty()) {
//			Node cur = queue.poll();
//			
//			for(int i=0; i<4; i++) {
//				int nx, ny;
//				nx = cur.x + dx[i];
//				ny = cur.y + dy[i];
//				
//				if(0 <= nx && nx < r && 0 <= ny && ny < c && ( map[nx][ny] == '.' || map[nx][ny] == 'L')) {
//					
//					if(map[nx][ny] == 'L') swan[swanIndex++] = (int)index - 48;
//
//					queue.add(new Node(nx, ny));
//					map[nx][ny] = index;
//				}
//			}
//			
//			
//			
//		}
//		
//		return true;
//		
//	}
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
