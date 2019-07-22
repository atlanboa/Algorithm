
public class RecursionTest {

	public static void main(String[] args) {
//		1부터 10까지의 숫자를 차례로 출력하라
//		for(int i=1; i<=10; i++) {
//			System.out.println(i);
//		}
		
//		printNum(10);
		
//		1부터 10까지의 합을 구하여 출력하라
		int sum =0;
		for(int i=0; i<=10; i++) {
			sum += i;
		}
		System.out.println(sum);
		
//		System.out.println(fibo(35));
		
//		자릿수를 입력받아서 모든 가능한 이진수 문자열을 출력하라(재귀로)
		doMakeBinary(3, "");
	
		
	}
	
	private static void doMakeBinary(int i, String string) {
		// TODO Auto-generated method stub
		if(i<=0) {
			System.out.println(string);
			return;
		}else {
			doMakeBinary(i-1, string+"0");
			doMakeBinary(i-1, string+"1");
		}
//		return;
		
	}

	static int fibo(int num) {
		if(num == 1 || num == 2) return 1;
		
		
		int sum = fibo(num-1) + fibo(num-2);
		
		
		
		return sum;
	}

	private static void printNum(int i) {
		// TODO Auto-generated method stub
		if(i==0) return;
		
		System.out.println(i);
		
		printNum(i-1);
		
		
	}

}
