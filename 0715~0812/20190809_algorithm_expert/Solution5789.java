import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5789 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int n, q, l, r;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			int[] box = new int[n+1];
			for (int i = 1; i <= q; i++) {
				st = new StringTokenizer(br.readLine());
				l = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				
				
				for(int j=l; j<=r; j++) {
					box[j]=i;
				}
			}
			System.out.print("#"+t+" ");
			for(int i=1; i<box.length; i++) {
				System.out.print(box[i]+" ");
			}
			System.out.println();

		}

	}

}
