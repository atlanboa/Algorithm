import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3074 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			int n, m;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			Node[] table = new Node[n];
			
			for(int i=0; i<n; i++) {
				int k = Integer.parseInt(br.readLine());
				table[i] = new Node(k, 0);
			}
			int cnt = 0;
			int time = 0;
			out:while(true) {
				time++;
				for(int i=0; i<n; i++) {
					
					table[i].process++;
					
					if(table[i].time==table[i].process) {
						table[i].process = 0;
						cnt++;
					}
					
					if(cnt == m) {
						break out;
					}
					
				}
				
				
				
				
			}
			
			System.out.println("#"+t+" "+time);
			
		}

		
		
	}
	
	static class Node{
		int time;
		int process;
		
		public Node(int time, int process) {
			this.time = time;
			this.process = process;
			
		}
	}
}
