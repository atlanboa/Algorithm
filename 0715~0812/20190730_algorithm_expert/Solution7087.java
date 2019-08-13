import java.util.Scanner;


public class Solution7087 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T;t++) {
			int n = sc.nextInt();
			String words ="";
			for(int i=0; i<n;i++) {
				words += sc.next().charAt(0);
			}
			int cnt = 0;
			for(int i=65; i<=90; i++) {
				if(words.contains(((char)i)+"")){
					cnt++;
				}else break;
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

}
