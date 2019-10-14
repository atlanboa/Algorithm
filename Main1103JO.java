import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1103JO {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int col, row;
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		Node[] store = new Node[n];
		for(int i=0; i<n; i++) {
			int side, offset;
			st = new StringTokenizer(br.readLine());
			side = Integer.parseInt(st.nextToken());
			offset = Integer.parseInt(st.nextToken());
			store[i] = new Node(side, offset);
		}
		st = new StringTokenizer(br.readLine());
		int side, offset;
		side = Integer.parseInt(st.nextToken());
		offset = Integer.parseInt(st.nextToken());
		
		Node dg = new Node(side, offset);
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += getDis(dg, store[i]);
		}
		
		System.out.println(sum);
		
		
	}

	private static int getDis(Node dg, Node store) {
		
		if(dg.side == store.side) return Math.abs(dg.offset-store.offset);
		
		if(dg.side==1) {
			if(store.side == 3) {
				return store.offset+dg.offset;
			}else if(store.side == 4) {
				return col-dg.offset+store.offset;
			}else {
				return Math.min(dg.offset+row+store.offset
						, 
						col-dg.offset+row+col-store.offset);
				
			}
		}else if(dg.side==2) {
			if(store.side == 3) {
				return row-store.offset+dg.offset;
			}else if(store.side == 4) {
				return col-dg.offset+row-store.offset;
			}else {
				return Math.min(dg.offset+row+store.offset
						, 
						col-dg.offset+row+col-store.offset);
				
			}
		}else if(dg.side==3) {
			if(store.side == 1) {
				return store.offset+dg.offset;
			}else if(store.side == 2) {
				return row-dg.offset+store.offset;
			}else {
				return Math.min(dg.offset+col+store.offset
						, 
						row-dg.offset+col+row-store.offset);
				
			}
		}else if(dg.side==4) {
			if(store.side == 1) {
				return col-store.offset+dg.offset;
			}else if(store.side == 2) {
				return row-dg.offset+col-store.offset;
			}else {
				return Math.min(dg.offset+col+store.offset
						, 
						row-dg.offset+col+row-store.offset);
				
			}
		}
		
		
		
		return 0;
	}

	static class Node{
		int side;
		int offset;
		
		public Node(int side, int offset) {
			this.side = side;
			this.offset = offset;
		}
	}
}
