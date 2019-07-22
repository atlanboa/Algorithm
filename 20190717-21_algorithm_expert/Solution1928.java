import java.util.Base64;
import java.util.Scanner;


public class Solution1928 {

	public static void main(String[] args) {
		//input base 64 encoding string
		//문자열 길이가 4의 배수

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			String encoded = sc.next();
			String decoded = new String(Base64.getDecoder().decode(encoded));
			System.out.format("#%d %s\n",t,decoded);
		}
	}

}
//6_32

//8 4