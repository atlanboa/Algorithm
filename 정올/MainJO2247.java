package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MainJO2247 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());
			int s, e;
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			pq.add(new Node(s, e));

		}

//		while (!pq.isEmpty()) {
//			Node temp = pq.poll();
//			System.out.println(temp.start + " " + temp.end);
//		}

		LinkedList<Node> list = new LinkedList<>();
		Node temp = pq.poll();
		list.add(temp);

		while (!pq.isEmpty()) {

			temp = pq.poll();
//			System.out.println(temp);
			if (list.peekLast().end < temp.start) {
				list.add(temp);
			} else {
				Node temp2 = list.pollLast();
//				System.out.println("temp2 : "+temp2);
				if(temp2.end < temp.end) {
					temp2.end = temp.end;	
				}
				
				list.add(temp2);
			}

		}
//		System.out.println();
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}

		int stay = 0;
		int nostay = 0;
		for (int i = 0; i < list.size(); i++) {
			temp = list.get(i);
			if (temp.end - temp.start > stay) {
				stay = temp.end - temp.start;
			}

			if (i < list.size() - 1 && list.get(i + 1).start - list.get(i).end > nostay) {
				nostay = list.get(i + 1).start - list.get(i).end;
			}
		}

		System.out.println(stay + " " + nostay);

//		while(!pq.isEmpty()) {
//			Node temp = pq.poll();
//			System.out.println(temp.start+" "+temp.end);
//		}

//		System.out.println(pq.peek());

	}

	static class Node implements Comparable<Node> {
		int start;
		int end;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			if (start > o.start) {
				return 1;
			} else {
				if (o.start == start) {
					return end > o.end ? 1 : -1;
				} else {
					return -1;
				}
			}
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + "]";
		}

	}
}