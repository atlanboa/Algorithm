import java.util.Scanner;
public class SolutionWs1 {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n;
        for(int t=1; t<=T; t++){
        	n = sc.nextInt();
            cnt = 0;
       		int[] arr= new int[n];
            backtracking(arr, 0);
			System.out.println("#"+t+" "+cnt);
        
        }
        

		
		
		

	}
	static int cnt = 0;
	static boolean sw = true;
	private static void backtracking(int[] arr, int depth) {
        
		if(depth == arr.length) {
			cnt++;
			return ;
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


}
