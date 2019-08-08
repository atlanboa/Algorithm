import java.util.Scanner;

public class Solution6718 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t =1; t<=T;t++) {
			System.out.println("#"+t+" "+chk(sc.nextInt()));
		}

	}

	private static int chk(int distance) {
		
		if(distance < 100) return 0;
		else if(distance < 1000) return 1;
		else if(distance < 10000) return 2;
		else if(distance < 100000) return 3;
		else if(distance < 1000000) return 4;
		else return 5;
	}

}
