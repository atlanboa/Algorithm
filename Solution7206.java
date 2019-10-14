import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution7206 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[] mem = new int[100000];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int number = Integer.parseInt(br.readLine());
			
			max = dfs(number);
			
			System.out.println("#"+t+" "+max);
		}
	}
	static int max;
	private static int dfs(int number) {
		if(number < 10) return 0;
		
		String s = ""+number;
		int len = s.length()-1;
		int maxCnt = 0;
		for(int i=1; i< 1<<len; i++) {
			int num = s.charAt(0)-'0';
			int mult = 1;
			
			for(int j=0; j<len; j++) {
				if((i & 1 <<j) == 0) {
					num = num * 10 + s.charAt(j +1) -'0';
				}else {
					mult *= num;
					num = s.charAt(j+1)-'0';
				}
			}
			
			mult *= num;
			
			if(mem[mult]==0) mem[mult] = dfs(mult);
			
			maxCnt = Math.max(mem[mult], maxCnt);
		}
		
		
		
		return maxCnt+1;
		
	}

}
