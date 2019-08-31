import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1221 {
	static String[] comp = {
			"ZRO",
			"ONE",
			"TWO",
			"THR",
			"FOR",
			"FIV",
			"SIX",
			"SVN",
			"EGT",
			"NIN"
	};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			String pNum = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int[] nums = new int[cnt];
			for(int i=0; i<cnt; i++) {
				
				nums[i] = findIdx(st.nextToken());

			}
			
			Arrays.sort(nums);
			
			System.out.println(pNum);
			for(int i=0; i<nums.length;i++) {
				System.out.print(comp[nums[i]]+" ");
			}
			System.out.println();
			
		}

	}
	private static int findIdx(String nextToken) {
		for(int i=0; i<=9; i++) {
			
			if(nextToken.equals(comp[i])) {
				System.out.println(nextToken);
				return i;
			}
			
		}
		return -1;
	}

}
