import java.util.Scanner;

public class Solution7732 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] current;
		int cur;
		String[] promise;
		int pro;
		int rest;
		
		for(int t=1; t<=T; t++) {
			//시간 받아서 초로 바꾸고 두 시간의 차를 다시 시분초로 변환
			
			
			current = sc.next().split(":");
			cur = Integer.parseInt(current[0])*3600 
					+ Integer.parseInt(current[1])*60 
					+ Integer.parseInt(current[2]);
			
			promise = sc.next().split(":");
			pro = Integer.parseInt(promise[0])*3600 
					+ Integer.parseInt(promise[1])*60 
					+ Integer.parseInt(promise[2]);
			//약속 시[0]:분[1]:초[2]
			rest = pro - cur;
			if(rest < 0) rest =  rest + 3600*24; //00:00:00에서 뺀 경우
			
			String clock, min, sec;
			
			clock = rest/3600<10?"0"+Integer.toString(rest/3600):Integer.toString(rest/3600);
			rest = rest%3600;
			min = rest/60<10?"0"+Integer.toString(rest/60):Integer.toString(rest/60);
			rest = rest%60;
			sec = rest<10?"0"+Integer.toString(rest):Integer.toString(rest);
			
			
			
			System.out.format("#%d %s:%s:%s\n", t, clock,min,sec);
			
		}
	}

}
