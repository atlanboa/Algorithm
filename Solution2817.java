import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2817 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		int n, k;
		int[] nums = null;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			nums = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				nums[i]=Integer.parseInt(st.nextToken());
			}
			int sum, cnt;
			cnt = 0;
			for(int i=0; i<(1<<n); i++) {
				sum = 0;
				for(int j=0; j<n; j++	) {
					if((i & (1 <<j))!=0) {
						sum += nums[j];
					}
				}
				if(sum == k) {
					cnt++;
				}
			}
			
			String result = "#"+t+" "+cnt;
			bw.write(result+"\n");
			bw.flush();
			
		}

	}

}
