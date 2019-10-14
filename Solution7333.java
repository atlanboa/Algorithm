import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution7333 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> box = new ArrayList<>();

		for (int t = 1; t <= T; t++) {
			box.clear();
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			int idx = 0;
			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(br.readLine());
				if (temp >= 50)
					count++;
				else
					idx++;
					box.add(temp);
			}

			if(idx==0) {
				System.out.println("#" + t + " " + count);
				continue;
			}
			Collections.sort(box);
			
            int top = box.get(--idx);
            int sum = top;
            for(int i=0;i<idx;i++) {
                sum+=top;
                if(sum>=50) {
                    top = box.get(--idx);
                    sum = top;
                    count++;
                }
            }
			
			
			
			System.out.println("#" + t + " " + count);

		}
	}

}
