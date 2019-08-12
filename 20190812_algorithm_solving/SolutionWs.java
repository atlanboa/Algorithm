import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SolutionWs {
	static String[] compareNums = 
			   {"0001101",
				"0011001",
				"0010011",
				"0111101",
				"0100011",
				"0110001",
				"0101111", 
				"0111011",
				"0110111",
				"0001011" };
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n, m;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			String row = null;
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				if(row == null && s.contains("1")) row = s;
			}
			
			int lastIndex = row.lastIndexOf('1');
			row = row.substring(lastIndex-55, lastIndex+1);
			
			int[] a = new int[8];
			for(int i=0; i<8; i++) {
				switch( row.substring(i*7, i*7+7) ) {
				case "0001101": a[i]=0; break;
				case "0011001": a[i]=1; break;
				case "0010011": a[i]=2; break;
				case "0111101": a[i]=3; break;
				case "0100011": a[i]=4; break;
				case "0110001": a[i]=5; break;
				case "0101111": a[i]=6; break;
				case "0111011": a[i]=7; break;
				case "0110111": a[i]=8; break;
				case "0001011": a[i]=9; break;
				default: a[i]=-9999;
				}
			}
			int result = 0;
			int check = (a[0]+a[2]+a[4]+a[6])*3+a[1]+a[3]+a[5]+a[7];
			if( check>9 && check%10==0 ) {
				result = a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+a[6]+a[7];
			}
			System.out.format("#%d %d\n", t, result);

			

		}
	}


}
