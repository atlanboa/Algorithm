package test;

import java.util.Scanner;

public class Solution2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num2 = 1;
		for(int i=0; i<=num; i++) {
			System.out.print(num2+" ");
			num2 *= 2;
		}
		
	}

}
