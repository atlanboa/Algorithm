package expertAlgo;

import java.util.Scanner;

public class Solution2056 {
	static int[] months = {0, 31, 28, 31, 30, 31, 30, 
			31, 31, 30, 31, 30, 31};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String date;
		
		for(int i=0; i<t; i++) {
			date = sc.next();
			check(i+1, date.substring(0, 4), date.substring(4, 6), date.substring(6, 8));
		}
	}
	
	public static void check(int num, String year, String month, String day) {
		int monInt;
		int dayInt;
		monInt = (month.charAt(0)-'0')*10 + (month.charAt(1)-'0');
		dayInt = (day.charAt(0)-'0')*10 + (day.charAt(1)-'0');
		if( 1 <= monInt && monInt <= 12 && 
				dayInt > 0 && (dayInt <= months[monInt]) ) {
			System.out.println("#"+num+" "+year+"/"+month+"/"+day);
		}else {
			System.out.println("#"+num+" -1");
		}
	
		
	}
}
