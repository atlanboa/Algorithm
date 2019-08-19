import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3456 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			
			
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			int temp3 = Integer.parseInt(st.nextToken());
			int result = -1;
			if(temp1 == temp2) {
				result = temp3;
			}else if(temp1 == temp3){
				result = temp2;
			}else {
				result = temp1;
			}
			
			System.out.println("#"+t+" "+result);
			
			
			
		}

	}

}
