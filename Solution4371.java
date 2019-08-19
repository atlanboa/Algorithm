import java.util.ArrayList;
import java.util.Scanner;




public class Solution4371 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		int n, cnt;
		ArrayList<Long> day = new ArrayList<Long>();
		
		for(int t=1; t<=T;t++) {
			
			n = sc.nextInt();
			day.clear();
			cnt = 0;
			
			for(int i=0; i<n; i++) {
				day.add(sc.nextLong());
			}
			
			day.remove(0);
			out : for(;;) {
//				long chk = day.get(0);
				long sub = day.get(0)-1;
				for(int i=0; i<day.size(); i++) {
					if((day.get(i)-1)%sub==0) {
						day.remove(i);
						
						
						i--;
					}
				}
				cnt++;
				if(day.size()==0) {
					break out;
				}
			}
			

			
			System.out.println("#"+t+" "+cnt);
			
			
			
		}
	}

}
