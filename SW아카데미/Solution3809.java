package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution3809 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Scanner sc = new Scanner(System.in);
//		int T = Integer.parseInt(br.readLine());
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			boolean[] chk = new boolean[1000];
//			int n = Integer.parseInt(br.readLine());
			int n = sc.nextInt();
			
//			st = new StringTokenizer(br.readLine());
			
			String str = "";
			for(int i=0; i<n; i++) {
				str += sc.nextInt();
				
			}
			
			
			int idx = 0;
			while(true) {
				if(!str.contains(Integer.toString(idx))) {
					break;
				}else {
					idx++;
				}
			}
			
			System.out.println("#"+t+" "+idx);

			
		}

	}



}
