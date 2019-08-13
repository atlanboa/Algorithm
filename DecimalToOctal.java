import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

// INPUT : 01D06079861D79F99F
// 16진수 입력을 2진수로 변환한 모두 이어 만든 스트링을 7자리씩 끊어서 10진수로 출력 
public class DecimalToOctal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] decimal = br.readLine().toCharArray();
		
		String binary = ""; 
		
		
		for(int i=0; i<decimal.length; i++) {
			int n = -1;
			switch(decimal[i]) {
			case '0':
				n = 0;
				break;
			case '1':
				n = 1;
				break;
			case '2':
				n = 2;
				break;
			case '3':
				n = 3;
				break;
			case '4':
				n = 4;
				break;
			case '5':
				n = 5;
				break;
			case '6':
				n = 6;
				break;
			case '7':
				n = 7;
				break;
			case '8':
				n = 8;
				break;
			case '9':
				n = 9;
				break;
			case 'A':
				n = 10;
				break;
			case 'B':
				n = 11;
				break;
			case 'C':
				n = 12;
				break;
			case 'D':
				n = 13;
				break;
			case 'E':
				n = 14;
				break;
			case 'F':
				n = 15;
				break;
			}
			
			binary += printBits(n);
		}
		LinkedList<Integer> list = new LinkedList<>();
		int cnt = -1;
		
		for(int i=0; i<binary.length(); i++) {
			cnt++;
			int num = 0;
			if(cnt == 7) {
				cnt = 0;
				int index = 0;
				int size = list.size();
				for(int j=0; j<size; j++	) {
					int temp = list.pollLast();
					System.out.print(temp + " ");
					num += (temp * (1<<index++) );
					
					
				}
				System.out.println();
				System.out.print("number? : "+num+" ");
				System.out.println();
				
			}
			
			
			list.add(binary.charAt(i)-'0');
		}
		System.out.println();
		System.out.println();
		System.out.println(binary);
		

		
		
	}



	private static String printBits(int i) {
		String result ="";
		for (int j = 3; j >= 0; j--) {
			result += (i & (1 << j)) != 0 ? "1" : "0";
		}
		return result;
	}

}
