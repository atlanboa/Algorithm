
public class MemoizationTest {
	static int[] fibo = new int[50];
	public static void main(String[] args) {
		//피보나치 수열에서 45번째 수를 구하여라
		
		int num = fibo1(10);
		int num2 = fibo2(45);
		System.out.println(num);
		System.out.println(num2);
	}

	static int fibo2(int i) {
		if(i == 1 || i == 2) return fibo[i] = 1;
		if(fibo[i] != 0) return fibo[i];
		
		return fibo[i] = fibo2(i-2)+fibo2(i-1);
		
	}

	static int fibo1(int i) {
		if(i == 1 || i == 2) return 1;
		
		return fibo1(i-2)+fibo1(i-1);
	}

}
