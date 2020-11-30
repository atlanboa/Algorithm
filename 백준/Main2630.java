package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class Main2630 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] paper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n;j++) {
				paper[i][j]	= Integer.parseInt(st.nextToken());
			}
		}
		
		bcolor = 0;
		wcolor = 0;
		
		dfs(0, 0, n);
		System.out.println(wcolor);
		System.out.println(bcolor);

	}
	static int bcolor;
	static int wcolor;
	private static void dfs(int x, int y, int n) {
		
		if(n==0) {
			return;
		}
		
		
		boolean flag = false;
		int color = paper[x][y];
		out: for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {

				if (color != paper[i][j]) {
					flag = true;
					break out;
				}

			}
		}
		
		//면적이 모두 같은 색이 아니면?
		if(flag) {
			 n = n/2;
			 dfs(x, y, n);
			 dfs(x+n,y, n);
			 dfs(x, y+n, n);
			 dfs(x+n, y+n, n);
			 
		}else {
			if(color == 1) {
				bcolor++;
			}else {
				wcolor++;
			}
		}

	}

}
