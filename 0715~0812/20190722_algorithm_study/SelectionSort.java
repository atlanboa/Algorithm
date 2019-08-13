import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,5,2,6,48,1,2,6,748,9};
		selection(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void selection(int[] arr) {
		int min, temp;
		
		for(int i=0; i<arr.length-1; i++) {
			min = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]<arr[min]) {
					min = j;
				}
			}
			if(min != i) {
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;	
			}
			
		}
	}

}
