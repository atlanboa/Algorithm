import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution7854 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		Set<Integer> set = new TreeSet<Integer>();
		int T = Integer.parseInt(br.readLine());
		double val = 0.1;
		
		while(val * 100 <= 1000000000) {
			set.add((int) (val * 10));
			set.add((int) (val * 20));
			set.add((int) (val * 25));
			set.add((int) (val * 50));
			set.add((int) (val * 100));
			if( val >= 1) set.add((int) (val * 125));
			
			val *= 10;

		}
		
		
//		Iterator<Integer> it = set.iterator();
//		
//		while(it.hasNext()) {
//			System.out.print(it.next()+" ");
//		}
//		System.out.println();
		
		for(int t=1; t<=T;t++) {
			
			int x = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			Iterator<Integer> it = set.iterator();
			
			while(it.hasNext()) {
				
				if ( x >= it.next()) {
					cnt++;
				}
				
				
			}
			
			bw.write("#"+t+" "+cnt+"\n");
		}
		
		br.close();
		bw.close();
		
		
		
		
	}

}
