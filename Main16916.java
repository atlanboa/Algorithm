import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16916 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		String p = br.readLine();
		if(kmp(s, p)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

		
		
	}
	private static boolean kmp(String parent, String pattern) {
		int[] table = makeTable(pattern);
		int parentSize = parent.length();
		int patternSize = pattern.length();
		
		int j=0; 
		for(int i=0; i<parentSize; i++) {
			while(j > 0 && parent.charAt(i) != pattern.charAt(j)) {
				j = table[j -1];
			}
			
			if(parent.charAt(i) == pattern.charAt(j)) {
				if(j == patternSize -1) {
					j = table[j];
					return true;
				}else {
					j++;
				}
			}
		}
		return false;
	}
	
	private static int[] makeTable(String pattern) {
		int patternSize = pattern.length();
		int[] table = new int[patternSize];
		int j=0; 
		for(int i=1; i<patternSize; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				//j가 0보다 크고 일치하지 않는다면 j는 j위치에서 1을 뺀 값으로 이동
				j = table[j - 1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				table[i] = ++j;
			}
		}
		
		
		return table;
		
	}

}
