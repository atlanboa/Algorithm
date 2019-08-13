import java.util.ArrayList;
import java.util.Scanner;

class Node1{
	String number;
	int price;
	
	public Node1(String n, int p) {
		number = n;
		price = p;
	}
}
public class Solution6900 {
	



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<Node1> match = new ArrayList<Node1>();
		for(int t=1; t<=T;t++) {
			match.clear();
			int n = sc.nextInt();
			int m= sc.nextInt();
			for(int i=0; i<n; i++) {
				String nTemp = sc.next();
				int nPrice = sc.nextInt();
				match.add(new Node1(nTemp, nPrice));
			}
			
			
			int sum =0;
			for(int i=0; i<m; i++) {
				String temp = sc.next();
				
				for(Node1 ma: match) {
					boolean flag = true;
					out : for(int h=0; h<temp.length(); h++) {
						if(temp.charAt(h) != ma.number.charAt(h)
								&& ma.number.charAt(h) != '*') {
							flag = false;
							break out;
						}
					}
					if(flag) sum += ma.price;
				}
				
				
			}
			
			System.out.println("#"+t+" "+sum);
		}

	}

}
