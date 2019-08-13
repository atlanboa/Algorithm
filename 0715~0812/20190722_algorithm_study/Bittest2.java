public class Bittest2 {

	public static void main(String[] args) {

		int a = 7;
//		00000111
//		00001000
		
//		int a = 100;
//		System.out.println(a);
//		a = 0x100; //16진수
//		System.out.println(a);
//		a = 0100; //8진수
//		System.out.println(a);
//		a = 0b100; //2진수
//		System.out.println(a);
		
		
		
		int arr[] = {3,6,7,1,5,4};
		int n = 6;
		
		for(int i =0; i<(1<<n);i++) {
			for(int j=0; j<n; j++) {
				if( (i & (1<<j))  == 1) {
					System.out.print(arr[j]+", ");
				}
			}
			System.out.println();
		}
	}

}
