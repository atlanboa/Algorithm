import java.util.Scanner;

public class Solution1945 {

	public static void main(String[] args) {
		//
		
//		8%2 == 0 8/2 4
//		4%2 == 0 4/2 2
//		2%2 == 0 2/2 1 
//		1이면 종료
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int num, index;
		int[] division = {2,3,5,7,11};
		int[] cnt;
		for(int i=1; i<=t; i++) {
			
			num = sc.nextInt();
			index = 0;
			cnt = new int[division.length];
			while(num >	1) {
				if(num % division[index] == 0) {
					num = num/division[index];
					cnt[index]++;
				}
				else index++;
			}
			System.out.printf("#%d %d %d %d %d %d\n", i, cnt[0], cnt[1], cnt[2], cnt[3], cnt[4]);
			
		}
		
		

	}

}
