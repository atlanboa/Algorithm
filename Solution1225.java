import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i=1; i<=10; i++) {
			
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			for(int j=0; j<8; j++) {
				
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			
			out : while(true) {
				
				for(int j=1; j<=5;j++) {
					int temp = list.poll();
					
					temp -= j;
					
					if(temp <= 0) {
						list.add(0);
						break out;
					}else {
						list.add(temp);
					}
				}

				
				
				
			}
			
			System.out.print("#"+t+" ");
			while(!list.isEmpty()) {
				System.out.print(list.poll()+" ");
			}
			System.out.println();
		}

	}

}
