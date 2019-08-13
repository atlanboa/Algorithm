package test;

import java.util.Scanner;

public class Solution1936 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int temp = num1 - num2;
		if(temp == 1) {
			System.out.println("A");
		}else if(temp == -1) {
			System.out.println("B");
		}else if(temp == -2) {
			System.out.println("A");
		}else {
			System.out.println("B");
		}
		
		
	}

}
