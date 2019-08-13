import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main3045 {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//		st = new StringTokenizer(br.readLine());
//		int n, m;
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());

	
		LinkedList<Node> list = new LinkedList<>();
		list.add(new Node(0, 2));
		list.add(new Node(1, 3));
		list.add(new Node(2, 4));
		list.add(new Node(3, 5));
		list.add(new Node(4, 6));
		list.add(new Node(5, 0));
		
		
		
//		char cmd;
//		int x, y;
//		for(int i=0; i<m; i++) {
//			st = new StringTokenizer(br.readLine());
//			cmd = st.nextToken().charAt(0);
//			x = Integer.parseInt(st.nextToken());
//			y = Integer.parseInt(st.nextToken());
//		}
		
		
		
		
		
		
	}
	


	
}
class DoubleLinkedList{
	Node front;
	Node end;
	public DoubleLinkedList() {
		this.front = null;
		this.end = null;
	}
	
	boolean isEmpty() {
		if(front == null) return true;
		else return false;
	}
	
	void add(Node node) {
		if(isEmpty()) {
			front = node;
			end = node;
		}else {
			end.next = node;
		}
	}
	
	void moveA(int x, int y) {
		
	}
	
	
	class Node{
		int data;
		Node pre;
		Node next;
	}
	
}
















