import java.util.Scanner;

public class Solution1288 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n, cnt, num;
		boolean[] numCnt;
		for(int t=1; t<=T; t++) {
			numCnt = new boolean[10];
			cnt = 0;
			n = sc.nextInt();
			//자릿수?
			while(!check(numCnt)) {
				num = n*(++cnt);
				for(int digit = num;digit>0;digit/=10) {
					
					numCnt[digit%10] = true;
				}
				
				
			}
			
			System.out.format("#%d %d\n", t, cnt*n);
		}
	}
	
	public static boolean check(boolean[] arr) {
		boolean flag = true;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == false) return false;
		}
		
		return flag;
	}

}
