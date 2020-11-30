package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution4050 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			
			for(int i=0; i<n; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int size = queue.size()%3;
			int sum = 0;
			for(int i=0; i<size; i++) {
				sum += queue.poll();
			}
			
			while(!queue.isEmpty()) {
				queue.poll();
				sum += queue.poll();
				sum += queue.poll();
			}
			
			System.out.println("#"+t+" "+sum);
			
		}
	}

}
