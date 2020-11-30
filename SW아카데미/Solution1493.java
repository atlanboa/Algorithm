package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1493 {
	static int[] compare = new int[143];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		compare[1] = 1;
		for(int i=2; i<compare.length; i++) {
			compare[i] = (i*(i+1))/2;
//			System.out.println(compare[i]);
		}
		
		
		
		
		for(int t=1;t<=T;t++) {
			int p, q;
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			
			System.out.println("#"+t+" "+find(p, q));
		}

	}
	private static int find(int p, int q) {
		
		Node a = findIndex(p);
		Node b = findIndex(q);
		
		int x = a.x + b.x;
		int y = a.y + b.y;
		
		return getPoint(x, y);
	}
	
	private static int getPoint(int x, int y) {

		return ((x+y-2)*(x+y-1)+2*x)/2;
	}
	private static Node findIndex(int p) {
		int x, y;
		x = 0; y = 0;
		for(int i=0; i<compare.length; i++) {
			if(p <= compare[i]) {
				int temp = compare[i]-p;
				
				x = i-temp;
				y = 1+temp;
				
//				System.out.println(i+" "+x+" "+y+" "+temp);
				break;
			}
		}
		
		
		return new Node(x, y);
	}

	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	

}
