package day2;

import java.util.Arrays;

public class Practice3 {
	static int[][] arr = new int[5][5];
	static int[] sortedArr = new int[25];
	static int[][] snailArr = new int[5][5];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setData();
		inputData();
		inputSnailData();
		for(int[] temp: snailArr) {
			System.out.println(Arrays.toString(temp));
		}
		
	}
	public static void setData() {
		int index = 1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				arr[i][j] = index++;
			}
		}
	}
	
	public static void inputData() {
		int index =0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				sortedArr[index++] = arr[i][j];
			}
		}
		Arrays.sort(sortedArr);
	}
	
	public static void inputSnailData() {
		int x = 0;
		int y = -1;
		int add = 1;
		int index = 1;
		int roop = 5;
		while(index <= 25) {
			for(int i=0; i<roop; i++) {
				y += add;
				snailArr[x][y] = index++;
				System.out.println("x : "+x+" y : "+y);
			}
			
			roop--;
			
			for(int i=0; i<roop; i++ ) {
				x += add;
				snailArr[x][y] = index++;
				
				System.out.println("x : "+x+" y : "+y);
			}
			
			add *= -1;
			
			
			
			
			
		}
	}
}
