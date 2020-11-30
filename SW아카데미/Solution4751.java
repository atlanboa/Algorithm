package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4751 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			String word = br.readLine();
			
			print(word);
			
		}

	}

	private static void print(String word) {
		int row = 5;
		int col = 4*word.length()+1;
		
		char[][] output = new char[row][col];
		
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				output[i][j]= '.';
			}
		}
		
		
		for(int i=0; i<word.length(); i++) {
			output[0][i*4+2] = '#';
			output[4][i*4+2] = '#';
		}
		
		for(int i=0; i<col/2; i++) {
			output[1][1+i*2] = '#';
			output[3][1+i*2] = '#';
		}
		
		
		for(int i=0; i<word.length()+1; i++	) {
			output[2][4*i] = '#';
		}
		
		
		for(int i=0; i<word.length(); i++) {
			output[2][i*4+2] = word.charAt(i);
		}
		
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(output[i][j]);
			}
			System.out.println();
		}
		
	}

}
