import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution4366 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println(Integer.valueOf("101000", 2));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			char[] num1 = br.readLine().toCharArray();
			char[] num2 = br.readLine().toCharArray();
			
			
			long result = -1;
			out:for(int i=0; i<num1.length; i++) {		
				num1[i] = num1[i]=='0'?'1':'0';
				
				long number1 = Long.valueOf(String.valueOf(num1), 2);
				long number2 = -1;
				
				for(int j=0; j<num2.length; j++) {
					
					char temp2 = num2[j];
					for(char k='0'; k<='2'; k++) {
						if(temp2 == k) continue;
						num2[j] = k;
						
						number2 = Long.valueOf(String.valueOf(num2), 3);
//						System.out.println(number1);
//						System.out.println(number2);
						if(number1==number2) {
							result = number1;
//							System.out.println(Arrays.toString(num1));
//							System.out.println(Arrays.toString(num2));
//							System.out.println(result);
							break out;
						}
					}
					
					num2[j] = temp2;
					
					
				}
				num1[i] = num1[i]=='0'?'1':'0';
				
			}
			
			System.out.println("#"+t+" "+result);
			
		}
		
		

	}

}