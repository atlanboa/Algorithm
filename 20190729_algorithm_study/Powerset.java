public class Powerset {
	static int cnt = 0;
	static int[] num = {1,2,3,4,5,6,7,8,9,10};
	public static void main(String[] args) {
		
		sumPowerset(0, 0);
		
		System.out.println(cnt);

	}

	private static void sumPowerset(int sum, int n) {
		if(n==10) return;
		else if(sum == 10) {
			cnt++;
			return ;
		}
		
		sumPowerset(sum+num[n], n+1);
		sumPowerset(sum, n+1);
				
	}

}
