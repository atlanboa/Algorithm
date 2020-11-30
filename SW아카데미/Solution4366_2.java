package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4366 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	/*
	 * 정식이의 실수!
	 * 송금할 금액을 까먹었때유
	 * 금액을 2진수와 3진수 두 가지 형태로 기억한대용
	 * 2진수와 3진수 한자리만 잘 못 기억하고 있다는것을 인지한대염
	 * 
	 * 두 진법의 한 자리씩만 틀리니깐 바꿔가면서 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			char[] binary = br.readLine().toCharArray();
			char[] ternary = br.readLine().toCharArray();
			
			int transfer = 0;
			
			out:for(int i=0; i<binary.length; i++) {
				binary[i] = binary[i]=='0'?'1':'0';
				for(int j=0; j<ternary.length; j++) {
					char cur = ternary[j];
					
					for(char k='0'; k<='2'; k++) {
						if(cur==k) continue;
						else {
							ternary[j] = k;
							String b = String.valueOf(binary);
							String te = String.valueOf(ternary);
							
							if(Integer.parseInt(b, 2)==Integer.parseInt(te, 3)) {
								transfer = Integer.parseInt(b, 2);
								break out;
							}
							
						}
					}
					ternary[j] = cur;
					
					
					
				}
				binary[i] = binary[i]=='0'?'1':'0';
			}
			
			
			System.out.println("#"+t+" "+transfer);
			
		}

	}
}
