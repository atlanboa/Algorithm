package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16987 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int[][] eggs;
	static int N;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		eggs = new int[N][2];

		// 0이 내구도, 무게
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		max = 0;

		dfs(0, 0);

		System.out.println(max);
	}

	private static void dfs(int depth, int cnt) {

		if (depth == N) {
			if (max < cnt) {
				max = cnt;
			}

			return;
		}

//		System.out.println("depth : "+depth+" 현재 계란 : "+eggs[depth][0]+" "+eggs[depth][1]); 
		
		
		

		if(eggs[depth][0] > 0) {
			int brokenEggs = 0;
			for (int i = 0; i < N; i++) {
				//들었던적이 없는 계란이고 계란이 살아있을때
				if(i != depth && eggs[i][0] > 0) {
							
					eggs[i][0] -= eggs[depth][1];
					eggs[depth][0] -= eggs[i][1];
//					printEgg();
					
					
					brokenEggs = (eggs[i][0]<=0?1:0) + (eggs[depth][0]<=0?1:0);
//					System.out.println(brokenEggs);
					
					dfs(depth+1, cnt + brokenEggs);
					eggs[i][0] += eggs[depth][1];
					eggs[depth][0] += eggs[i][1];	
					
				}
			}
			if(brokenEggs == 0) {
				dfs(depth+1, cnt);
			}
		}else {
			dfs(depth+1, cnt);
		}
		

		



	}

	private static void printEgg() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(eggs[i]));
		}
//		System.out.println();
	}

	static int max;

	static class Egg {
		int weight;
		int life;

		public Egg(int weight, int life) {
			this.weight = weight;
			this.life = life;
		}
	}
}
