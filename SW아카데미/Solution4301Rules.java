package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4301 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
//	static int[][] map = new int[1000][1000];
	static int[] c1 = new int[1000];
	static int[] c2 = new int[1000];

	public static void main(String[] args) throws NumberFormatException, IOException {
//		int T = Integer.parseInt(br.readLine());
//
//		search();
//
//		for(int t=1;t<=T;t++) {
//			
//			st = new StringTokenizer(br.readLine());
//			int n, m;
//			n = Integer.parseInt(st.nextToken());
//			m = Integer.parseInt(st.nextToken());
//			
//			int result = getCnt(n, m);
//			System.out.println("#"+t+" "+result);
//		}

		initC();
		initC2();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			int n, m;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			int result = getC(n, m);
			System.out.println("#" + t + " " + result);
		}

	}

	private static int getC(int n, int m) {
		int sum = 0;
		int cnt =0;
		boolean oddFlag = true;
		for(int i=0; i<m; i++) {
			cnt++;
			if(oddFlag) {
				sum += c1[n-1];
			}else {
				sum += c2[n-1];
			}
			if(cnt >= 2) {
				cnt = 0;
				oddFlag = oddFlag? false:true;
			}
		}
		
//		if(m%2==0) {
//			
//			if( (m/2)%2 == 0 ) {
//				sum = (2*c1[n-1])*(m/2) +(2*c2[n-1])*(m/2); 
//			}else {
//				sum = (2*c1[n-1])*(m/2+1) +(2*c2[n-1])*(m/2-1);
//			}
//			
//		}else {
//			
//			if( (m/2)%2 == 0 ) {
//				sum = (2*c1[n-1])*(m/2) +(2*c2[n-1])*(m/2) + c1[n-1];
//			}else {
//				sum = (2*c1[n-1])*(m/2) +(2*c2[n-1])*(m/2) + c2[n-1];
//			}
//			
//			
//		}
//			
		
		
		return sum;
	}

	private static void initC2() {
		c2[0] = c2[1] = 0;

		for (int i = 2; i < 1000; i++) {
			c2[i] = c1[i - 2];
		}

	}

	private static void initC() {

		int input = 1;
		int i = 0;
		while (i < 1000) {
			c1[i++] = input++;

			for (int j = 0; j < 3 && i < 1000; j++) {
				c1[i++] = input;
			}

			input++;
		}

	}

//	private static int getCnt(int n, int m) {
//		int cnt = 0;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//
//				if (map[i][j] == 1) {
//					cnt++;
//				}
//
//			}
//		}
//
//		return cnt;
//	}

	static int[] dx = { 2, -2, 0, 0 };
	static int[] dy = { 0, 0, 2, -2 };

//	private static void search() {
//
//		for (int i = 0; i < 1000; i++) {
//			for (int j = 0; j < 1000; j++) {
//				if (map[i][j] == 0) {
//					map[i][j] = 1;
//					for (int d = 0; d < 4; d++) {
//						int nx = i + dx[d];
//						int ny = j + dy[d];
//
//						if (nx >= 0 && ny >= 0 && nx < 1000 && ny < 1000) {
//							map[nx][ny] = 2;
//						}
//
//					}
//				}
//
//			}
//		}
//
//	}
}
