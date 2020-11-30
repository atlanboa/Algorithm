package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution5672 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t=1;t<=T;t++) {
			
			int n = Integer.parseInt(br.readLine().trim());
			String temp = "";
			
			for(int i=0; i<n; i++) {
				temp += br.readLine().trim();
			}
			char[] word = temp.toCharArray();
			
			int l, r;
			l =0;
			r = n-1;
			String result = "";
			while(l<=r) {				
				if(word[l] < word[r]) {
					//왼쪽이 오른쪽보다 작으면
					result += word[l++];
				}else {
					
					if(word[l] > word[r]) {
						result += word[r--];
					}else {
						//왼오가 같은 경우
						if(check(word, l, r)) {
							//왼쪽이 사전순으로 더 빠르면?
							result += word[l++];
						}else {
							result += word[r--];
						}
		
					}
	
				}			
			}
			
			System.out.println("#"+t+" "+result);
			
		}
	}

	
	private static boolean check(char[] word, int l, int r) {
		
		while(word[l++]==word[r--] && l < r) {
			
			if(word[l]< word[r]) {
				return true;
			}		
			
		}	
		return false;
	}


	static class Node implements Comparable<Node>{
		String w;
		int l;
		int r;
		public Node(String w, int l, int r) {
			this.w = w;
			this.l = l;
			this.r = r;
		}
		@Override
		public int compareTo(Node o) {
			return o.w.compareTo(w);
		}
	}
}
