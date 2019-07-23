import java.util.Scanner;

public class Solution7675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int lines, index;
		int[] cnt;
		char[] word;
		
		for (int t = 1; t <= T; t++) {

			lines = sc.nextInt(); //구문자 개수, 문장 개수
			cnt = new int[lines]; //문장마다 이름 개수를 세기위한 배열
			index = 0; //라인 번호
			while (index<lines) {
				word = sc.next().toCharArray();
				//단어 첫알파벳 체크 , 알파벳이고, 대문자이면? 이름으로 간주하고 체크 시작
				cnt[index] += checkWord(word);
				index += checkSep(word);
				
			}

			System.out.print("#"+t+" ");
			for(int i=0; i<cnt.length; i++) {
				System.out.print(cnt[i]+" ");
			}
			System.out.println();
			

		}

	}
	static int checkSep(char[] word) {
		if(word[word.length-1]=='.'||
				word[word.length-1]=='!'||
				word[word.length-1]=='?') {
			return 1;	
		}
		return 0;
	}
//	단어 구성되는 방법 
//	첫 char가 알파벳 and 대문자? 이름일 가능성이 있음
	static int checkWord(char[] word) {
		if(Character.isAlphabetic(word[0]) && Character.isUpperCase(word[0])) {
			//한글자다?
			if(word.length==1) return 1;
			//아니면 이름이라 생각하고 체크
		}else {
			return 0;
		}
		
		for(int i=1; i<word.length-1; i++) {
			if(!Character.isAlphabetic(word[i])) return 0;
			else if(!Character.isLowerCase(word[i])) return 0;		
		}
		//BB Ab0일때 카운트하고
		//4글잔디 3번까지는 okay, 4번째가 구문자? 이름
		if(Character.isAlphabetic(word[word.length-1])) {
			return Character.isLowerCase(word[word.length-1])?1:0;
		}else if(checkSep(word)==1) {
			return 1;
		}else {
			return 0;
		}
		
			
		
	}
}
