import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3260 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			char[] num1 = st.nextToken().toCharArray();
			char[] num2 = st.nextToken().toCharArray();
			
			int index1 = num1.length-1;
			int index2 = num2.length-1;
			int rounding = 0;
			String result = "";
			while(index1 >= 0 || index2 >= 0) {
				
				
				int n1 = 0;
				int n2 = 0;
				int ret = 0;
				if(index1 >= 0 && index2 >= 0) {
					n1 = num1[index1]-'0';
					n2 = num2[index2]-'0';
//					System.out.println(n1+" "+n2);
					ret = n1+n2+rounding;
//					System.out.println("ret "+ret);
				}else if(index1 < 0) {
//					System.out.println("index2");
					ret = (num2[index2]-'0')+rounding;
				}else {
//					System.out.println("index1");
					ret = (num1[index1]-'0')+rounding;
				}
				rounding = 0;
				if(ret >= 10) {
					rounding = 1;
					ret %= 10;
				}
//				System.out.println("l ret : "+ret);
				result = ret + result;
				
				index1--;
				index2--;
				
				if(index1 < 0 && index2 < 0 && rounding == 1) {
					result = 1+result;
				}
				
			}
			
			System.out.println("#"+t+" "+result);
			
		}

	}


}
