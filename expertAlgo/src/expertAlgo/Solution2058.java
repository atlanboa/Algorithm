package expertAlgo;

import java.util.Scanner;

public class Solution2058 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int sum=0;
		int temp;
		for(int i=0; i<num.length(); i++) {
			sum += num.charAt(i) - '0';
		}
		System.out.println(sum);
	}

}
