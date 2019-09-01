import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1208 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		for(int t=1;t<=10;t++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int[] block = new int[100];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<100;i++) {
				
				block[i] = Integer.parseInt(st.nextToken());
				
				
			}
			
			for(int i=0; i<n;i++) {
				
				dump(block);
				
				
			}
			
			System.out.println("#"+t+" "+findSub(block));
			
		}
		

	}

	private static int findSub(int[] block) {
		int max = 0;
		for(int i=0; i<block.length;i++) {
			
			if(block[i]>block[max]) max = i;
			
		}
		
		int min = 0;
		for(int i=0; i<block.length;i++) {
			
			if(block[i]<block[min]) min = i;
		}
		return block[max]-block[min];
	}

	private static void dump(int[] block) {
		
		int max = 0;
		for(int i=0; i<block.length;i++) {
			
			if(block[i]>block[max]) max = i;
			
		}
		
		int min = 0;
		for(int i=0; i<block.length;i++) {
			
			if(block[i]<block[min]) min = i;
		}
		
		block[max]--;
		block[min]++;
		
		
	}

}
