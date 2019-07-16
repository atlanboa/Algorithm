package day2;

public class BubbleSort {
	static int[] data = new int[30];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setRandomData();
		sortData();
		for(int i:data) {
			System.out.print(i+" ");
		}
	}
	
	
	public static void setRandomData() {
		for(int i = 0; i<data.length; i++) {
			data[i] = (int)(Math.random()*100)+1;
		}
	}
	
	public static void sortData() {
		int temp;
		for(int i=0;i<data.length;i++) {
			for(int j = 0; j<data.length-i-1; j++) {
				if(data[j] > data[j+1]) {
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;					
				}
			}
		}
	}
}
