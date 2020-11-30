package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3378 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int p, q;
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			String[] pCode = new String[p];
			String[] qCode = new String[q];

			for (int i = 0; i < p; i++) {
				pCode[i] = br.readLine();
			}

			for (int i = 0; i < q; i++) {
				qCode[i] = br.readLine();

			}
			
			
			
			result = new int[q-1];
			Arrays.fill(result, -2);
			
			for (int r = 1; r <= 20; r++) {
				for (int c = 1; c <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						if (isAvailable(r, c, s, pCode)) {
							processIndent(r, c, s, qCode);
						}
					}
				}
			}
			
			System.out.print("#"+t+" 0 ");
			for(int i=0; i<result.length;i++) {
				System.out.print(result[i]+" ");
			}System.out.println();


		}


	}

	static int[] result = null;

	private static boolean isAvailable(int r, int c, int s, String[] pCode) {
		// ( , { , [ , ), }, ] 개수 파악
		int rCount = 0, cCount = 0, sCount = 0;
		
		for (int i = 0; i < pCode.length - 1; i++) {

			for (char p : pCode[i].toCharArray()) {
				if (p == '(') {
					rCount++;
				} else if (p == '{') {
					cCount++;
				} else if (p == '[') {
					sCount++;
				} else if (p == ')') {
					rCount--;
				} else if (p == '}') {
					cCount--;
				} else if (p == ']') {
					sCount--;
				}
			}

			int pCount = 0;
			for (char p : pCode[i + 1].toCharArray()) {
				if (p != '.') {
					break;
				} else {
					pCount++;
				}
			}

			if (pCount != r * rCount + c * cCount + s * sCount) {
				return false;
			}
		}
		return true;
	}

	private static void processIndent(int r, int c, int s, String[] qCode) throws IOException {
		
		// ( , { , [ , ), }, ] 개수 파악
		int rCount = 0, cCount = 0, sCount = 0;
		for (int i = 0; i < qCode.length - 1; i++) {

			for (char p : qCode[i].toCharArray()) {
				if (p == '(') {
					rCount++;
				} else if (p == '{') {
					cCount++;
				} else if (p == '[') {
					sCount++;
				} else if (p == ')') {
					rCount--;
				} else if (p == '}') {
					cCount--;
				} else if (p == ']') {
					sCount--;
				}
			}

			
			
			int pCount =  r * rCount + c * cCount + s * sCount;
			
			if(result[i] == -2) {
				result[i] = pCount;
			}else {
				if(result[i]==pCount) {
					continue;
				}else {
					result[i] = -1;	
				}
				
			}
//			System.out.println(i+" : indent in "+ result[i]);

		}

	}

}
