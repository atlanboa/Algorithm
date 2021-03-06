package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
//7810. 승현이의 질문
public class Solution7810 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			int n= Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] numbers = new int[n];
			
			for(int i=0;i<n; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(numbers);
			
			int left, right;
			left = 0; right = numbers[n-1];
			int max = 0;
			while(left <= right) {
				int mid = (left+right)/2;
//				System.out.println(mid);
				if(isPromising(mid, numbers)) {
					left = mid +1;
					if(max < mid) {
						max = mid;
					}
				}else {
					right = mid - 1;
				}
				
				
			}
//			System.out.println();
			bw.write("#"+t+" "+max+"\n");
//			System.out.println(max);
			
		}
		bw.flush();
		bw.close();
		
	}

	private static boolean isPromising(int num, int[] numbers) {
		
		boolean flag = true;
		int cnt = 0;
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] >= num) {
				cnt++;
				if(numbers.length-i+cnt-1 < num) {
					flag = false;
					break;
				}
			}
		}
		
		
		return flag;
	}

}
