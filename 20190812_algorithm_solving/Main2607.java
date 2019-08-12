import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2607 비슷한 단어
public class Main2607 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String word = br.readLine();
//		System.out.println(word);
		String[] comp = new String[T-1];
		
		int[] alpha = new int[26];

		for(int t=0; t<T-1; t++) {
			comp[t] = br.readLine();
		}
		

		for(int i=0; i<word.length(); i++)
		{
			alpha[(int)(word.charAt(i))-65]++;

		}
		int cnt = 0; 
		for(int i=0; i<comp.length; i++) {
			
			cnt += chk(alpha, comp[i], word.length());
			
			
		}
		
		System.out.println(cnt);
	}

	private static int chk(int[] compWord, String word, int length) {
		
		
		
		int[] alpha = new int[26];
		for(int i=0; i<word.length(); i++) {
			alpha[(int)(word.charAt(i))-65]++;
		}


		boolean flag1 = false;
		boolean flag2 = false;
		for(int i=0; i<alpha.length; i++) {
			if(compWord[i] != alpha[i]) { // 같은 경우?
				if(Math.abs(compWord[i] - alpha[i]) >= 2) { //2개 차이나면? 다른 단어
					return 0;
				}else if(flag1 && flag2) {
					return 0;
				}else if(!flag1 && Math.abs(compWord[i] - alpha[i]) == 1) { // 한개 차이나면?
					flag1 = true;
				}else if(flag1 && Math.abs(compWord[i] - alpha[i]) == 1){
					flag2 = true;
				}
			}
		}
		
		return 1;
		
		
	}

}

