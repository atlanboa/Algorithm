import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
//1157. 단어공부, 백준
public class Main1157 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		String word = br.readLine().toUpperCase();
		HashMap<Character, Integer> map = new HashMap<>();
		
		int[] alpha = new int[26];
		//65~90 
		for(int i=65; i<=90; i++) {
			map.put((char)i, 0);
		}
		
		for(int i=0; i<word.length(); i++) {
//			map.put(word.charAt(i), map.get(word.charAt(i))+1);
//			alpha[word.charAt(i)-'0']++;
			int index = (int)word.charAt(i)-65;
//			System.out.println(index);
			alpha[index]++;
		}
		int maxIndex = 0;
		int cnt = 0;
		for(int i=0; i<26; i++) {
			if(alpha[maxIndex] < alpha[i]) {
				maxIndex = i;
				cnt = 1;
			}else if(alpha[maxIndex] == alpha[i]) {
				cnt++;
			}
		}
		
		if(cnt >= 2) {
			System.out.println("?");
		}else {
			System.out.println((char)(maxIndex+65));
		}
		
		
	}

}
