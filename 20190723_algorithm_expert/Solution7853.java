import java.util.Scanner;

public class Solution7853 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		char[] word;
		long cnt;
		for(int t=1; t<=T; t++) {
			word = sc.next().toCharArray();
			cnt = getCnt(word);
			//문자 개수, 문자 길이
			
			
			//1000000000 10e+7 Math.pow(10, 10)+7\
			//i번째 문자에는? 원래 단어의 i-1, i, i+1번째 문자를 친다.
			System.out.format("#%d %d\n",t, cnt);
			
		}
	}

	static long getCnt(char[] word) {
		// TODO Auto-generated method stub
		
		long ret = 1;
		if(word.length == 1) return ret;
		else if(word[0] != word[1]) ret*=2;
		
		for(int i=1; i<word.length-1; i++) {
			
			boolean ret1 = word[i-1]!=word[i];
			boolean ret2 = word[i]!=word[i+1];
			boolean ret3 = word[i-1]!=word[i+1];
			
			if(ret1 && ret2 && ret3) ret *=3;
			else if(!ret1 && !ret2 && !ret3) ret *= 1;
			else ret *= 2;
			

			ret %= 1000000007;
			
		}
		if(word[word.length-2] != word[word.length-1]) ret *= 2;
		
		
		return ret%1000000007;
	}

}
