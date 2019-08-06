import java.util.Arrays;

public class MergeSortTest {
	public static void main(String[] args) {
		int[] arr = {6, 10, 31, 2, 19, 8,1, 21, 60};
		temp = new int[arr.length];
		mergeSort(arr, 0 , arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}

	private static void mergeSort(int[] arr, int start, int end) {
		//종료
		if(start>=end) return;
		
		
		
		int mid = (start+end)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		merge(arr, start,mid, end);
		
	}
	static int[] temp;
	private static void merge(int[] arr, int start, int mid, int end) {
		
		int l, r;
		l = start;
		r = mid +1;
		int index = l;
		while(l <= mid && r <= end) {
			
			if(arr[l] < arr[r]) {
				temp[index++] = arr[l++];
			}else {
				temp[index++] = arr[r++];
			}
			
			
		}
		
		while(l <= mid) {
			temp[index++] = arr[l++];
		}
		while(r <= end) {
			temp[index++] = arr[r++];
		}
		
		for(int i = start; i<=end; i++) {
			arr[i] = temp[i];
		}
		
	}
	
	
}
