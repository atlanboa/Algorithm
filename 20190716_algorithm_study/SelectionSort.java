package day2;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = new int[30];
		setRandomData(data);
		selectionSort(data);
		System.out.println(Arrays.toString(data));
		
		
	}
	public static void setRandomData(int[] data) {
		for(int i = 0; i<data.length; i++) {
			data[i] = (int)(Math.random()*100)+1;
		}
	}
	
	public static void selectionSort(int[] data) {
		int temp;
		int tempNum;
		for(int i=0; i<data.length; i++) {
			temp = i;
			for(int j=i; j<data.length; j++) {
				if(data[temp] > data[j]) {
					temp = j;
				}
			}
			tempNum = data[i];
			data[i] = data[temp];
			data[temp] = tempNum;
		}
		
	}
	

}
