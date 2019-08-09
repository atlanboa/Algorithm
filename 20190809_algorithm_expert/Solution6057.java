import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6057 {
	static int triangle;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int x, y;
		for(int t=1; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			triangle = 0;
			
			boolean [][] graph = new boolean[n+1][n+1];
			
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				graph[x][y] = true;
				graph[y][x] = true;
			}
			
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					for(int k=1; k<=n; k++) {
						
						if(graph[i][j] && graph[j][k] && graph[k][i]) triangle++;
						
						
						
					}
				}
			}
			
			
			System.out.println("#"+t+" "+triangle/6);
		}
		
	}

}