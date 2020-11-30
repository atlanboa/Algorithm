package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution7701 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());

			Set<String> queue = new HashSet<>();
			

			for (int i = 0; i < n; i++) {
				String name = br.readLine();

				queue.add(name);

			}
			PriorityQueue<Person> output = new PriorityQueue<>();
			Iterator<String> it = queue.iterator();
			
			while(it.hasNext()) {
				String input = it.next();
				;
//				System.out.println(temp);
				output.add(new Person(input, input.length()));
			}
			
			bw.write("#"+t+"\n");
			int size = queue.size();
			for(int i=0;i<size;i++) {
				bw.write(output.poll().name+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

	static class Person implements Comparable<Person>{
		String name;
		int length;

		public Person(String name, int length) {
			this.name = name;
			this.length = length;

		}



		
		@Override
		public String toString() {
			return "Person [name=" + name + ", length=" + length + "]";
		}


		@Override
		public int compareTo(Person o) {
			if(length > o.length) {
				return 1;
			}else {
				if(length == o.length) {
					return name.compareTo(o.name);
				}else {
					return -1;
				}
				
			}
		}


	}
}
