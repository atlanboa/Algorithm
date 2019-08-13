import java.util.Scanner;

public class Solution6485 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();

			}

			int p = sc.nextInt();
			int[] c = new int[p];
			for (int i = 0; i < p; i++) {
				c[i] = sc.nextInt();
			}
			
			int[] result = new int[p];
			
			chk(result, a, b, c, n);
			
			System.out.print("#"+t+" ");
			for(int i=0; i<result.length;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}

	}

	private static void chk(int[] result, int[] a, int[] b, int[] c, int n) {
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<c.length; j++) {
				if(c[j] <= b[i] && c[j] >= a[i]) result[j]++;
				
			}
			
			
		}
		
			
			
			
			
			
	}
		
	

}
