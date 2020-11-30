package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution7792 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		//65~90 A~Z
//		for(int i=65; i<91; i++) {
//			System.out.println((char)i);
//		}
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			int n = Integer.parseInt(br.readLine());
			Student[] students = new Student[n];
			for (int i = 0; i < n; i++) {
				String name = br.readLine();
				students[i] = new Student(name);

				for (int j = 65; j < 91; j++) {
					if(name.contains(((char)j)+"")) {
						students[i].cnt++;
					}
				}
			}
			
			Arrays.sort(students, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					if(o1.cnt < o2.cnt) {
						return 1;
					}else {
						if(o1.cnt == o2.cnt) {
							return o1.name.compareTo(o2.name);
						}else {
							return -1;
						}
					}
					
				}
			});
			
//			for(int i=0; i<n; i++) {
//				System.out.println(students[i]);
//			}
		
			bw.write("#"+t+" "+students[0].name+"\n");
			
		}
		bw.flush();
		bw.close();
	}

	static class Student {
		String name;
		int cnt;

		public Student(String name) {
			this.name = name;
			cnt = 0;

		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", cnt=" + cnt + "]";
		}
		
	}

}
