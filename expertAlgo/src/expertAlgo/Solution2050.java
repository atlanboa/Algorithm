package expertAlgo;

import java.util.Scanner;

public class Solution2050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String Alpha = sc.next();
		
		for(int i =0; i<Alpha.length(); i++) {
			System.out.print(Alpha.charAt(i)-'A'+1+" ");
		}
	}

}
