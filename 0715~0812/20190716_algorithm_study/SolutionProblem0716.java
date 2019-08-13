package day2;

import java.util.Scanner;

public class SolutionProblem0716 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = 10;
		int dump;
		int[] blocks = new int[100];
		for(int i=0; i<t; i++) {
			dump = sc.nextInt();
			for(int j=0; j<100; j++) {
				blocks[j] = sc.nextInt();
			}
			
			for(int j=0; j<dump; j++) {
				blocks[max(blocks)]--;
				blocks[min(blocks)]++;
			}
			
			System.out.println("#"+(i+1)+" "+(blocks[max(blocks)]-blocks[min(blocks)]));
		}
	}
	
	public static int max(int[] arr) {
		int maxNum = 0;
		int index = 0;
		for(int i=0; i<arr.length; i++) {
			if(maxNum < arr[i]) {
				maxNum = arr[i];
				index = i;
			}
		}
		return index;
	}
	public static int min(int[] arr) {
		int minNum = arr[0];
		int index = 0;
		for(int i=0; i<arr.length; i++) {
			if(minNum > arr[i]) {
				minNum = arr[i];
				index = i;
			}
		}
		return index;
	}

}
