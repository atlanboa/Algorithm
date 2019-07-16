package day1;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		System.out.println("Hello World!");
		int a = 10;
		//		byte, short, char, int, long, float, double

		for(int i = 0; i<1000; i++) {

		}
		for(int i = 1000; i>= 0; i--) {

		}
		float x = (float)20.4;
		x++;
		++x;

		char ch = 65;

		System.out.println(ch);
		ch++;
		System.out.println(ch);
		//		ch = ch + 1;
		byte b1, b2, b3;
		b1 = b2 = 4;
		//		b3 = b1 + b2;
		//		최소 연산이 int
		//		$$ || ! , & , | , ! <, >, ==, !=, >=, <=
		//		+, =, *, /, %, (**)
		//		(4 > 2)? "aa":"bb"

		String s = "1";
		s += "2";

		int num = 100;

		if (num > 2) {
			System.out.println("2보다 크다");
		} else {
			System.out.println("2보다 작거나 같다");
		}

		int num1 = 0;
		//		switch문에 올수 있는게 제약되는디 int, char, short, byte
		switch(num) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			System.out.println("그외");
			break;

		}

		//		while, for
		//		for(;;) {
		//			System.out.println(i);
		//		}

		//		int i = 0;
		//		while(true) {
		//			System.out.println(i);
		//			i++;
		//			if(i >= 10) {
		////				break;
		//				continue;
		//			}
		//		}
		aaa:for(int i =0; i<10;i++) {
			for(int j=0; j<5; j++) {
				if(j == 2) {
					break aaa;
				}
				System.out.println(i+" , "+ j);
			}
		}

		//		int[] arr = {1,2,3,4,5,6};
		//		
		//		int [] brr[], crr, drr;
		//		
		//		int k[], j, l;

		int[] arr = {1,2,3,4,5, 7};
		System.out.println(arr.length);

		int sum = 0;

		//		for(int i =0; i<arr.length; i++) {
		//			sum += arr[i];
		//		}

		for(int n : arr) {
			sum += n;
		}
		System.out.println(sum);

		int[][] brr = new int[4][];
		brr[0] = new int[5];
		brr[1] = new int[4];
		brr[2] = new int[3];
		brr[3] = new int[2];

//		brr[2][6] = 99;

//		System.out.println(brr[2][6]);
//		System.out.println(brr[2][5]);


		for(int i =0; i < brr.length; i++) {
			for(int j =0; j<brr[i].length; j++) {
				System.out.print(brr[i][j] + " ");	
			}
			System.out.println();

		}























	}

}
