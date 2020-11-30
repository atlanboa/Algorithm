package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//7829. 보물왕 태혁
public class Solution7829 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int p = Integer.parseInt(br.readLine());
			Integer[] numbers = new Integer[p];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<p ;i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(numbers);
						
			int result = numbers[0]*numbers[p-1];
			
			bw.write("#"+t+" "+result+"\n");
			
			
		}
		bw.flush();
		bw.close();
	}

}
