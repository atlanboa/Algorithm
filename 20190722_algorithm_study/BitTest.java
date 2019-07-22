

public class BitTest {

	public static void main(String[] args) {
		byte a = 13, b = -7; //00000111 => 11111001
//		int c = b >> 1; //00001110
//		int c = b << 35; // 2^32승 기반이라 35%32 나머지 3까지 
		int c = b >> 2;
//		11111001 => >>는 비트 복사
//		11111001 => >>> 0을 채움
		
		
		System.out.println(c);
		
		
		
		System.out.println(c);
		
		
		
		
//		00001101     00000111
//		11111000 => 00000111 + 1 => 00001000 => -8
		
//		int c = a & b;
//		int c = a | b;
//		System.out.println(~b);
//		bit 단위를 0->1 1->0으로
		
		
//		String s = null;
//		if(s != null && s.length() >=10) {
//			
//		}
		
		
		
		
//		boolean flag = a> 200 && ++b > 3;
//		//자바는 짧은 연산의 논리 연산 short circuit
//		
//		System.out.println(flag + ", " + b);
//		
//		System.out.println(1<<7);
	}

}
