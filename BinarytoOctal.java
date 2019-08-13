import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// INPUT : 00000001111000000011000000111100110000110000111100111100111111001100111
// 이진
public class BinarytoOctal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] binary = br.readLine().toCharArray();
		
		for(int i=0; i<binary.length/7; i++) {
			
			int num = 0;
			int k=6;
			for(int j=i*7; j<=i*7+6; j++) {

				num += ((binary[j]-'0' )*(1 << k--));
			
			}
			System.out.println();
			System.out.print(num+" ");
			
			
		}
		

		
		
	}

}
