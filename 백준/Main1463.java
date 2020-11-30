package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1463 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[] mem;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n = Integer.parseInt(br.readLine());
		mem = new int[1000001];
		Arrays.fill(mem, Integer.MAX_VALUE);
		mem[0] = 0;
		mem[1] = 0;
		mem[2] = 1;
		mem[3] = 1;
		
		for(int i=4; i<=n; i++) {
			
			if(i%3 == 0) {
				mem[i] = mem[i/3]+1;	
			}
			
			if(i%2 == 0) {
				mem[i] = Math.min(mem[i], mem[i/2]+1);
			}
			
			mem[i] = Math.min(mem[i], mem[i-1]+1);
			
		}
		
		
		
		
		
		
		/*
		 * 3가지 연산
		 * 1. 3으로 나누어 떨어지면 3으로 나눔
		 * 2. 2로 나누어 떨어지면 2로 나눔
		 * 3. 1을 뺸다.
		 */
		
		
		System.out.println(mem[n]);
	}
//	private static int dfs(int n) {
//		
//		if(n == 1) return 0;
//		
//		int min = 100000000;
//		
//		
//		if(n>=3 && n%3==0) {
//			if(mem[n/3] == 0) mem[n/3] = dfs(n/3);
//			min = Math.min(min, mem[n/3]);
//			
//		}
//		
//		if(n>=2 && n%2==0) {
//			if(mem[n/2] == 0) mem[n/2] = dfs(n/2);
//			min = Math.min(min, mem[n/2]);
//			
//		}
//		
//		if(mem[n-1]==0) {
//			mem[n-1] = dfs(n-1);
//		}
//		min = Math.min(min, mem[n-1]);
//		
//		
//		
//		return min +1;
//	}
}
