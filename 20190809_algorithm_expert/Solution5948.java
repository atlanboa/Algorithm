import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution5948 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> list	= null;
		for(int t=1; t<=T;t++) {
			int[] nums = new int[7];
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<7; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
//			for(int i=0; i<5; i++) {
//				for(int j=i+1; j<7; j++) {
//					for(int k=j+1; k<7; k++) {
//						
//						list.remove(new Integer(nums[i]+nums[j]+nums[k]));
//						list.add(nums[i]+nums[j]+nums[k]);
//						
//						
//					}
//				}
//			}
			
			combin(nums, 0);
			
			
			Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					
					return o2-o1;
				}
			});
			
			
			System.out.format("#%d %d\n", t, list.get(4));
			
			
		}
		
		

	}

	private static void combin(int[] nums, int depth) {
		if(depth == 3) {
			return;
		}
		
	}

}
