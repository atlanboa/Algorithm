
public class NQueenTest {

	public static void main(String[] args) {
		int n = 4;
		int[] arr= new int[n];
		backtracking(arr, 0);
		
		
		
		

	}
	static int cnt = 0;
	static boolean sw = true;
	private static void backtracking(int[] arr, int depth) {
		if(depth == arr.length) {
//			boolean flag = check(arr);
//			if(flag) {
			for(int i=0; i<arr.length; i++) {
//				System.out.print(arr[i] + " ");
			}
//			System.out.println();
//			}
//			sw = false;
			cnt++;
//			체크
			return;
		}
		for(int i=0; i<arr.length; i++) {
			arr[depth] = i;
			if(sw && isPromising(arr, depth)) {
				backtracking(arr, depth+1);
			}
		}
		
	}

	private static boolean isPromising(int[] arr, int depth) {
		boolean flag = true;
		
		for(int i= 0; i<depth;i++) {
			if(arr[i] == arr[depth]) {
				flag = false;
				break;
			}
			if((arr[depth]-arr[i]) == (depth-i)) {
				flag = false;
				break;
			}
			if((arr[i]-arr[depth]) ==(depth-i))
			{
				flag = false;
				break;
			}
			
		}
	
		
		return flag;
	}

	private static boolean check(int[] arr) {
		
		boolean flag = true;
		outer : for(int i=0; i<arr.length; i++) {
			for(int j= i+1; j<arr.length;j++) {
				if(arr[i] == arr[j]) {
					flag = false;
					break outer;
				}
				if((arr[i]-arr[j]) == (j-i)) {
					flag = false;
					break outer;
				}
				if((arr[i]-arr[j]) ==(j-1))
				{
					flag = false;
					break outer;
				}
				
			}
		}
		
		
		return flag;
	}

}
