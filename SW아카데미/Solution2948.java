package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution2948 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		HashSet<String> set1 = null;
		HashSet<String> set2 = null;

		for(int t=1; t<=T;t++) {
			int n, m;
			st =new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m  = Integer.parseInt(st.nextToken());
			set1 = new HashSet<>();
			set2 = new HashSet<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				set1.add(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				set2.add(st.nextToken());
			}
			
			
			int result = compare(set1, set2);
			String output = "#"+t+" "+result;
			
			bw.write(output+"\n");
			bw.flush();
			
			
		}

	}

	private static int compare(HashSet<String> set1, HashSet<String> set2) {
		
		int cnt = 0;
		Iterator<String> it = set1.iterator();
		String temp = null;
		while(it.hasNext()) {
			temp = it.next();
			if(set2.remove(temp)) {
				cnt++;
			}
			
		}
		
		
		return cnt;
	}

}
