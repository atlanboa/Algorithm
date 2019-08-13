package test;

import java.util.Scanner;

public class Solution2029 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int num1, num2;
		for(int i=0; i<t; i++) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			System.out.println("#"+(i+1)+" "+num1/num2+" "+num1%num2);
		}
	}

}
