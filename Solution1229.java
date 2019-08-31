import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1229 {
	static ArrayList<String> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		
		for(int t=1;t<=10;t++) {
			
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			list = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				list.add(st.nextToken());
			}
			
			int cnt = Integer.parseInt(br.readLine());
			
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<cnt; i++) {
				
				String cmd = st.nextToken();
				
				if(cmd.equals("I")) {
					insert(st);
				}else if(cmd.equals("D")) {
					delete(st);
				}else {
					add(st);
				}
			}
			
			
			System.out.print("#"+t+" ");
			for(int i=0; i<10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}

	private static void add(StringTokenizer st) {
		int y;
		y = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<y; i++) {
//			System.out.println(i+" "+y);
			list.add(st.nextToken());
		}
		
		
	}

	private static void delete(StringTokenizer st) {
		int x, y;
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<y; i++) {
			
			list.remove(x);
			
			
		}
	}

	private static void insert(StringTokenizer st) {
		int x, y;
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<y; i++) {
			list.add(x++, st.nextToken());
		}
	}

}
