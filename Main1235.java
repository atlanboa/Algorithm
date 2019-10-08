import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

//1235. 학생번호
public class Main1235 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		String[] students = new String[N];
		
		for(int i=0; i<N; i++) {
			students[i] = br.readLine();
		}
		int k = 0;
		Set<String> set= new HashSet();
		out:for(int i=1; i<=7; i++) {
			for(int j=0; j<N; j++) {
				set.add(students[j].substring(7-i));
			}
			if(set.size()!=N) {
				set.clear();
				continue;
			}else {
				k = i;
				break out;
			}
		}
		
		System.out.println(k);
		
	}

}
