import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//1965. 상자넣기 백준 LIS
public class Main1965 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] boxes = new int[n];
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(boxes));
		
		int[] dp = new int[n];
		int idx = 0;
		
		dp[0] = boxes[0];
		
		
		for(int i=1; i<n; i++) {
			
			//현재 박스가 박스 컨테이너의 마지막보다 클때
			if(dp[idx] < boxes[i]) {
				dp[++idx] = boxes[i];
				
			}else {
				
				dp[lower_bound(dp, boxes[i],idx)] = boxes[i];
			}
			
//			System.out.println("idx : "+idx+" "+Arrays.toString(dp));
			
		}
		System.out.println(idx + 1);
	}
	private static int lower_bound(int[] arr, int num, int size) {
		
		
		//큰 수 중에 가장 가까운 수
		int left =0, right = size;
		while(left < right) {
			
			int mid = (left + right)/2;
			
			if(arr[mid] >= num) {
				right = mid;
			}else {
				left = mid + 1;
			}
			
			
			
			
		}
		
		
		return right;
	}

}
