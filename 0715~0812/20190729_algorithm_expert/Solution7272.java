import java.util.Scanner;

public class Solution7272 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String result = "";
		for(int t=1; t<=T; t++) {
			String A = sc.next();
			String B = sc.next();
			
			if(A.length() != B.length()) result="DIFF";
			else {
				result = checkString(A, B);
			}
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static String checkString(String a, String b) {
		String result="SAME";
		for(int i=0; i<a.length(); i++) {
			
			switch(a.charAt(i)){
			case 'B':
				if(b.charAt(i)!='B') return "DIFF";
				else {
					continue;
				}
			case 'A':
			case 'D':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
				if(b.charAt(i) == 'A' || b.charAt(i) == 'D' || b.charAt(i) == 'P' ||
						b.charAt(i) == 'O' || b.charAt(i) == 'Q' ||b.charAt(i) == 'R') {
					continue;
				}else {
					return "DIFF";
				}
			default:
				if(b.charAt(i)=='B' || b.charAt(i) == 'A' || b.charAt(i) == 'D' || b.charAt(i) == 'P' ||
				b.charAt(i) == 'O' || b.charAt(i) == 'Q' ||b.charAt(i) == 'R') return "DIFF";
				
			}
				
			
			
			
		}
		
		
		return result;
	}

}
