package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5603 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			for(int i=0; i<n;i++) {
				nums[i] = Integer.parseInt(br.readLine());
			}
			
			int avg = getAvg(nums);
			
			int result = 0;
			
			for(int i=0; i<n;i++) {
				if(nums[i]>avg) {
					result += nums[i]-avg;
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
			

	}

	private static int getAvg(int[] nums) {
		
		int sum = 0;
		for(int i=0; i<nums.length;i++) {
			
			sum += nums[i];
			
			
		}
		
		sum = sum/nums.length;
		return sum;
	}

}
