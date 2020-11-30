package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution4796 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			
			int n = sc.nextInt();
//			st = new StringTokenizer(br.readLine());
			
			int[] mountains = new int[n];
			int up = 0;
			int down = 0;
			int result = 0;
			mountains[0] = sc.nextInt();
			for(int i=1; i<n; i++) {
				mountains[i] = sc.nextInt();
				
				if(mountains[i] > mountains[i-1]) {
					if(down==0) {
						up++;	
					}else {
						result += down*up;
						up = 0;
						down = 0;
						up++;
					}
					
				}else if(mountains[i] < mountains[i-1]) {
					down++;
				}
			}
			
			result += down*up;
			System.out.println("#"+t+" "+result);
			
		}

	}

}
