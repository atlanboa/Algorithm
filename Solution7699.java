import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution7699 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			
			
			alpha = new HashMap();
			st=new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			max = 0;
			map = new char[r][c];
			visited = new boolean[r][c];
			for(int i=0; i<r; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			dfs(0,0,0);
			
//			System.out.println(max);
			if(r==1 && c==1) max=1;
			bw.write("#"+t+" "+max+"\n");
		}
		bw.flush();
		bw.close();
	}
	static int max;
	static char[][] map; 
	static int r,c;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited;
	static HashMap<Character, Integer> alpha;
	private static void dfs(int x, int y, int depth) {
		
		if(alpha.containsKey(map[x][y])) {
			//경로상에서 이미 방문했던 유적지(알파벳)라면
			if(max < depth) {
				max = depth;
			}
			return;
		}
		
		//방문한 좌표가 아니고 , 다른 유적지의 방문이라면?
		//해시맵에 넣고
		alpha.put(map[x][y], 0);
		//방문표시
//		visited[x][y] = true;
		
		
		for(int i=0; i<4; i++) {
			int nx, ny;
			nx = x + dx[i];
			ny = y + dy[i];
			//범위 내의 좌표인가?
			if(0<=nx && nx < r && 0<=ny && ny < c /*&& !visited[nx][ny]*/) {
				dfs(nx, ny, depth+1);
			}
			
			
		}
		
		alpha.remove(map[x][y]);
	}

}

//IEFCJ
//FHFKC
//FFALF
//HFGCF
//HMCHH