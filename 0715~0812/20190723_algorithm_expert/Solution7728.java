import java.util.Scanner;

public class Solution7728 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean[] nums;
		String num;
		int temp, cnt;
		for(int t=1; t<=T; t++) {
			nums = new boolean[10];
			cnt = 0;
			num = sc.next();
			
			for(int i=0; i<num.length(); i++) {
				temp =  num.charAt(i) -'0';
				nums[temp] = true;
				
			}
			
			for(int i=0; i<nums.length; i++) {
				if(nums[i]) cnt++;
			}
			
			System.out.format("#%d %d\n",t,cnt);
		}
			
	
	}

}
