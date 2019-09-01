import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1213 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			
			tc = Integer.parseInt(br.readLine());
			
			String word = br.readLine();
			String line = br.readLine();
			
			int length = word.length();
			int cnt = 0;
			for(int i=0; i<line.length()-length+1; i++) {
				
				if(line.substring(i, i+length).equals(word)) {
					cnt++;
				}
	
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		}
	}

}
