import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution5356 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			ArrayList[] list = new ArrayList[5];
			int max = 0;
			for(int i=0; i<5; i++) {
				list[i] = new ArrayList<Character>();
				char[] temp = br.readLine().toCharArray();
				if(max < temp.length) max = temp.length;
				for(int j=0; j<temp.length; j++) {
					list[i].add(temp[j]);
				}
				
			}
			
			int index = 0;
			System.out.print("#"+t+" ");
			while(index < max) {
				for(int i=0; i<5; i++) {
					if(list[i].size() != 0) {
						char temp = (char) list[i].remove(0);	
						System.out.print(temp);
					}
					
				}
				index++;
			}
			System.out.println();
			
		}

	}

}
