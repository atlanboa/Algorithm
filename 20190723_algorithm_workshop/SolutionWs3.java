import java.util.Scanner;

public class SolutionWs3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String word1, word2;
		String result;
		for(int t=1; t<=T; t++) {
			result = "SAME";
			word1 = sc.next();
			word2 = sc.next();
			
			if(word1.length() != word2.length()) result = "DIFF"; 
			else {
				for(int i=0; i<word1.length(); i++) {
					
					if(word1.charAt(i) =='B') {
						if(word2.charAt(i) != 'B') {
							result = "DIFF";
							break;
						}
						else {
							continue;
						}
					}else if(word1.charAt(i) == 'A' || //ADOPQR일때 
							word1.charAt(i) == 'D' ||
							word1.charAt(i) == 'O' ||
							word1.charAt(i) == 'P' ||
							word1.charAt(i) == 'Q' ||
							word1.charAt(i) == 'R') {
						
						if(word2.charAt(i) == 'A' ||
								word2.charAt(i) == 'D' ||
								word2.charAt(i) == 'O' ||
								word2.charAt(i) == 'P' ||
								word2.charAt(i) == 'Q' ||
								word2.charAt(i) == 'R') {
							continue;
						}
						else {
							result = "DIFF";
							break;
						}
						
					}else {
						if(word2.charAt(i)=='B') {
							result = "DIFF";
							break;
						}else if(word2.charAt(i) == 'A' || //ADOPQR일때 
								word2.charAt(i) == 'D' ||
								word2.charAt(i) == 'O' ||
								word2.charAt(i) == 'P' ||
								word2.charAt(i) == 'Q' ||
								word2.charAt(i) == 'R') {
							result = "DIFF";
							break;
						}
						else {
							continue;
						}
					}
					
					
					
					
				}
			}
			
			
			System.out.format("#%d %s\n",t, result);
		}
	}

}
