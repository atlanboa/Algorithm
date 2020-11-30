package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution7088 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int n, q;
			st =new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n+1];
			int[][] arrSum = new int[n+1][4];
			
			for(int i=1; i<=n; i++) {
				int cow = Integer.parseInt(br.readLine());
				arr[i] = cow;
				arrSum[i][1] += arrSum[i-1][1];
				arrSum[i][2] += arrSum[i-1][2];
				arrSum[i][3] += arrSum[i-1][3];
				arrSum[i][cow]++;
			}
			
			bw.write("#"+t+"\n");
			for(int i=0; i<q; i++) {
				int l, r;
				st = new StringTokenizer(br.readLine());
				l = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				
				bw.write((arrSum[r][1]-arrSum[l-1][1])+" "+
						(arrSum[r][2]-arrSum[l-1][2])+" "+
						(arrSum[r][3]-arrSum[l-1][3])+"\n");
				
			}
				
			
		}
		bw.flush();
		bw.close();
	}

}
