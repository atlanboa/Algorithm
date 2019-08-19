import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3376 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[100];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		for(int i=3; i<100; i++) {
			arr[i] = arr[i-2]+arr[i-3];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			int n = Integer.parseInt(br.readLine());
			
			System.out.println("#"+t+" "+arr[n-1]);
			
		}

	}

}
