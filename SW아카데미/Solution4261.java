package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution4261 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static char[][] keypad = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
	static HashMap<String, Integer> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			String number;
			int n;
			number = st.nextToken();
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			cnt = 0;
			out : for (int i = 0; i < n; i++) {
				String word = st.nextToken();

				for (int j = 0; j < number.length(); j++) {
					if(getKeyPad(number.charAt(j), word.charAt(j))) {
						continue;
					}else {
						continue out;
					}
				}
				
				cnt++;

			}
			
			System.out.println("#"+t+" "+cnt);
		}

	}
	static int cnt;
	private static boolean getKeyPad(char number, char word) {
		boolean flag = false;
		int curIdx = number-'0';
		for(int i=0; i<keypad[curIdx].length; i++) {
			if(word==keypad[curIdx][i]) {
				return true;
			}
		}
		
		return flag;
	}
}
