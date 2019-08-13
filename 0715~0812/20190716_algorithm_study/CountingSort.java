package day2;

import java.util.Arrays;

//  ( 큰수 * 작은수 ) > ( 작은수 * 큰수 ) 퍼포먼스 더 좋음
public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = new int[30];
		
		int[] sortedData = new int[30];
		final int k = 5;
		setRandomData(data);
		countingSort(data, sortedData, k);
		System.out.println(Arrays.toString(sortedData));

	}
	
	public static void setRandomData(int[] data) {
		for(int i = 0; i<data.length; i++) {
			data[i] = (int)(Math.random()*6);
		}
	}
	
	public static void countingSort(int[] data, int[] sortedData, int k) {
		int[] count = new int[k+1];
		
		for(int i =0; i<data.length; i++) {
			count[data[i]]++;
		}
		
		for(int i=1; i<count.length; i++) {
			count[i] += count[i-1];
		}
		
		int index;
		for(int i=data.length-1; i>=0; i--) {
			index = --count[data[i]];
			sortedData[index]=data[i];
		}
	}
	
	

}
