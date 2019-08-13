
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Combination {
	static boolean[] visited = null;
	static ArrayList<Integer> list	= null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			int[] nums = new int[7];
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<7; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			visited = new boolean[7];		
			combi(nums, 0, 0);
			
			
			
			Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					
					return o2-o1;
				}
			});
			
			System.out.println(cnt);
			System.out.format("#%d %d\n", t, list.get(4));
			
			
		}
		
		

	}
	static int cnt = 0;
	private static void combi(int[] nums, int depth, int index) {
		if(depth == 3) {
			int sum = 0;
			for(int i=0; i<visited.length; i++) {
				
				if(visited[i]) {
					sum += nums[i];
					System.out.print(nums[i]+" ");
				}
			}
			cnt++;
			System.out.println();
			list.remove(new Integer(sum));
			list.add(sum);
			return;
		}
		if(index >= 7) return;
		
		
		visited[index] =true;
		combi(nums, depth+1, index+1);
		visited[index] =false;
		combi(nums, depth, index+1);
	}

}
