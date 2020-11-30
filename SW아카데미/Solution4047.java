package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4047 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String str = br.readLine();
			String result = "";
			int cards = str.length()/3;
			int[][] countCard = new int[4][15];
			boolean flag = false;
			for(int i=0; i<cards; i++) {
				
				int p = chkPattern(str.charAt(i*3));
				int index = 0;
				index += (str.charAt(i*3+1)-'0')*10;
				index += str.charAt(i*3+2)-'0';
				
				
				
//				System.out.println(p+" "+index);
				
				if(countCard[p][index] != 0) {
					flag = true;
					break;
				}else {
					countCard[p][index]++;
					countCard[p][14]++;
				}
			}
			
			if(flag) result = "ERROR";
			else {
				for(int i=0; i<4; i++) {
					result += (13-countCard[i][14])+" ";
				}
			}
			System.out.println("#"+t+" "+result);
			
			
			
		}
	}
	
	static int chkPattern(char a){
		switch(a) {
		case 'S':
			return 0;
		case 'D':
			return 1;
		case 'H':
			return 2;
		case 'C':
			return 3;
		}
		return 0;
	}

}
