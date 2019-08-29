import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1240 {
	static String[] comp = {
			"0001101",
			"0011001",
			"0010011",
			"0111101",
			"0100011",
			"0110001",
			"0101111",
			"0111011",
			"0110111",
			"0001011"
	};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			
			int n, m;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			String temp = null;
			String temp2 = null;
			int lastIndex = -1;
			for(int i=0; i<n; i++) {
				temp = br.readLine();
				if(temp.contains("1")) {
					lastIndex = temp.lastIndexOf("1");
					temp2 = temp;
				}
			}
			
			int[] nums = new int[8];
			int firstIndex = lastIndex - 55;
			int sum = 0;
			for(int i=0; i<8; i++) {
				nums[i] = compare(temp2.substring(firstIndex, firstIndex+7));
				sum += nums[i];
				firstIndex+=7;
			}
			
//			System.out.println(Arrays.toString(nums));
			//검증코드 ((홀수 자리의 합 x 3) + 짝수 자리의 합 + 검증 코드 % 10) == 0
			String result = null;
			int flag = ((nums[0]+nums[2]+nums[4]+nums[6])*3 + nums[1]+nums[3]+nums[5]+nums[7])%10;
			if(flag == 0) {
				result = " "+sum;
			}else {
				result = " 0";
			}
			
			System.out.println("#"+t+result);
		}
	}
	private static int compare(String substring) {
//		System.out.println(substring);
		for(int i=0; i<=9; i++) {
			
			if(substring.equals(comp[i])) {
				return i;
			}
			
			
		}
		return 0;
	}
}
