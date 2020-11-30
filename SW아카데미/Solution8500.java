package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution8500 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Integer[] sits = new Integer[n];
			for(int i=0; i<n; i++) {
				sits[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(sits, Comparator.reverseOrder());
//			System.out.println(Arrays.toString(sits));
			
			int result = sits[0];
			for(int i=0; i<n; i++) {
				result += sits[i];
			}
			result += sits.length;
			
			String output = "#"+t+" "+result+"\n";
			bw.write(output);
			
		}
		
		bw.flush();
		bw.close();
		

	}

}
