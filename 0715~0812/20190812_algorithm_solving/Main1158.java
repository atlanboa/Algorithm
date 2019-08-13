import java.util.ArrayList;
import java.util.Scanner;

public class Main1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> output = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			list.add(i);
		}
		int cnt = 0;
		while(!list.isEmpty()) {
			
			for(int i=0; i<list.size();i++) {
				cnt++;
				if(cnt == k) {
					output.add(list.remove(i));
					cnt = 0;
					i--;
				}

			}
			
		}
		
		
		System.out.print("<");
		for(int i=0; i<output.size(); i++) {
			System.out.print(output.get(i));
			if(i != output.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");

	}

}
