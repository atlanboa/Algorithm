import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import sun.net.www.content.audio.basic;

public class Solution3234 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
/*
 * N개의 서로 다른 무게를 가진 무게 추
 * 무게 추를 양팔 저울에 왼쪽, 오른쪽에 올립니다.
 * 오른쪽 무게 추의 총합 =< 왼쪽에 올리는 총합 이 항상 만족해야 된다.
 * 이런 경우의 수를 모두 구하라.
 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int[] chu;
			int N;
			
			N = Integer.parseInt(br.readLine());
			chu = new int[N];
			
			st = new StringTokenizer(br.readLine());
			//추 전체 합 계산줌
			
			for(int i=0; i<N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			boolean[] visited = new boolean[N];
			dfs(0, 0, 0, visited, chu, N);
			System.out.println("#"+t+" "+cnt);
			
			
		}

	}
	
	static int cnt;
	private static void dfs(int depth, int left, int right, boolean[] visited, int[] chu, int N) {
		if(right > left) {
			return;
		}
		
		if(depth == N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(depth+1, left+chu[i], right, visited, chu, N);
				dfs(depth+1, left, right+chu[i], visited, chu, N);
				visited[i] = false;
			}
		}
		
	}
	

}
