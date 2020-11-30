package SW아카데미;

public class Solution3131 {
	
	public static void main(String[] args) {
		boolean[] prime = new boolean[1000001];
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i=2; i<Math.sqrt(1000000); i++) {
			for(int j=i*i; j<prime.length; j+=i) {
				prime[j] = true;
			}
		}
		
		
		for(int i=0; i<prime.length; i++) {
			if(!prime[i]) System.out.print(i+" ");
		}
		

	}

}
