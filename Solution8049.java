import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution8049 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		Pattern pattern = Pattern.compile("^((FF+MCM+)*(FC+MF)*)+$");
		Matcher matcher = null;
		for(int t=1;t<=T;t++) {
			
		
			String str = br.readLine();			
			matcher = pattern.matcher(str);
			String result ="#"+t+" "+(matcher.find()?"DETECTED!":"NOTHING!");
			bw.write(result+"\n");
			bw.flush();

		}
		bw.close();
	}

}
