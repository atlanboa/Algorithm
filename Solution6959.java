import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6959 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			String num = br.readLine().trim();
			boolean flag = true;
			//true A start
			while(num.length() > 1) {
				
				int a, b;
				a = num.charAt(0)-'0';
				b = num.charAt(1)-'0';
				
				num = (a+b)+num.substring(2);
				
				if(flag) {
					flag = false;
				}else {
					flag = true;
				}
				
				
			}
			
			System.out.println("#"+t+" "+(flag?"B":"A"));
			
			
		}
	}

}
