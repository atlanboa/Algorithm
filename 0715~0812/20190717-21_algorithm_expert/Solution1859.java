package test;

import java.util.Scanner;

public class Solution1859 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;
		int[] nums;
		int sum;
		for(int i=0; i<t; i++) {
			n=sc.nextInt();
			nums = new int[n];
			sum = 0;
			for(int j=0; j<n; j++) {
				nums[j] = sc.nextInt();
			}
			for(int j=0; j<n-1; j++) {
				sum += calValue(nums, j+1);
			}
		}
	}
	
	public static int calValue(int[] arr, int index) {
		int value = 0;
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			if(max > arr[i]) {
				max = arr[i];
			}
		}
		return max-arr[index-1];
	}

}
