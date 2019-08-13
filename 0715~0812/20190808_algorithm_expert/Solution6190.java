import java.util.Scanner;

public class Solution6190 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T; t++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			
			for(int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			
			int max = -1;
			
			for(int i=0; i<n-1; i++) {{
				for(int j=i+1; j<n; j++) {
					boolean flag = chk(Integer.toString(nums[i]*nums[j]));
					if(flag) {
						if(max < nums[i]*nums[j]) {
							max = nums[i]*nums[j];
						}
					}
						
				}
			}
				
				
			}
			
			System.out.println("#"+t+" "+max);
			
			
		}

	}

	private static boolean chk(String num) {
		if(num.length()==1) return false;
		char[] nums = num.toCharArray();
		for(int i=0; i<num.length()-1;i++) {
			if(nums[i] > nums[i+1]) {
				return false;
			}
		}

		return true;
	}

}