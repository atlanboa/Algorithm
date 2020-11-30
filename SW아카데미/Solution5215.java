package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5215 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++	) {
			int n, l;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			max = -99999999;
			ingre = new int[n][2];
			visited = new boolean[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				ingre[i][0]=  Integer.parseInt(st.nextToken());
				ingre[i][1]=  Integer.parseInt(st.nextToken());
			}
			
			dfs(ingre, 0, n, l, 0, 0);
			
			System.out.format("#%d %d\n",tc, max);
			
		}
		
		
		
	}

	static int[][] ingre;
	static int max;
	static boolean[] visited;
	private static void dfs(int[][] ingre, int index, int n, int l, int score, int cal) {
		//칼로리합이 1000이 넘으면?
		if(cal > l) return;
		//index까지 왔으면
		if(index == n) {
			if(score > max) max = score;
			return;
		}
		
		dfs(ingre, index+1, n, l, score+ingre[index][0], cal+ingre[index][1]);
		dfs(ingre, index+1, n, l, score, cal);
		
		
		
	}

}
