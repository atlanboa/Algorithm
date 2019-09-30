import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3074G {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			int n, m;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			long[] tables = new long[n];
			long max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				tables[i] = Integer.parseInt(br.readLine());
				if(max < tables[i]) {
					max = tables[i];
				}
			}
			long result = max*m;
			long left = 0, right = max*m;
//			System.out.println(right);
			
			
		    while (left < right){
		        
		    	
		    	
		    	long mid = (left + right) / 2;
        
		        
//		        long cnt = isPromising(mid, tables);
		    	long cnt = 0;
                for(int j=0; j<n; j++) {
                    cnt += mid/tables[j];
                }
		        		


//		        System.out.println("cnt : "+cnt+" left : "+left+" right : "+right+" mid : "+mid);
		        if (cnt < m)//
		            left = mid + 1;
		        else {
		        	if(result > mid) {
		        		result = mid;
		        	}
		        	right = mid;
		        }
//		        System.out.println("after cnt : "+cnt+" left : "+left+" right : "+right+" mid : "+mid);

		 
		    }


		    bw.write("#"+t+" "+result+"\n");
				
		}
		bw.flush();
		bw.close();
	}
	private static long isPromising(long mid, int[] tables) {
		
		long cnt = 0;
		
		for(int i=0; i<tables.length; i++) {
			
			cnt += mid/tables[i];
			
		}
		
		
		return cnt;
	}


}
