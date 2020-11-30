package SW아카데미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8382 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int x1, y1, x2, y2, subX, subY;
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			subX = Math.abs(x2-x1);
			subY = Math.abs(y2-y1);
			
			int cnt = 0;
			
			if(subX > subY) {
				
				cnt += subY*2;
				
				subX -= subY;
				
				if(subX % 2 == 0) {
					cnt += subX * 2;
				}else {
					cnt += (subX-1)*2+1;
				}
				
				
				
			}else if(subX == subY) {
				
				cnt += subX*2;
				
			}else {
				
				cnt += subX*2;
				
				subY -= subX;
				
				if(subY % 2 == 0) {
					cnt += subY * 2;
				}else {
					cnt += (subY-1)*2+1;
				}
				
				
			}
			
			System.out.println("#"+t+" "+cnt);
		}

	}

}
