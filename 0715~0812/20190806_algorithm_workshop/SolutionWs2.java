import java.util.LinkedList;
import java.util.Scanner;

public class SolutionWs2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int length, cmdNum;
		for(int t=1; t<=T; t++) {
			length = sc.nextInt();
			LinkedList<String> li = new LinkedList<>();
			for(int i=0; i<length; i++) {
				li.offer(sc.next());
			}
			cmdNum = sc.nextInt();
			for(int i=0; i<cmdNum; i++) {
				sc.next();
				int pos = sc.nextInt();
				int wordNum = sc.nextInt();
				
				for(int j=0; j<wordNum; j++) {
					li.add(pos++, sc.next());
				}
				
			}
			
			System.out.println("#"+t+" ");
			for(int i=0; i<10; i++) {
				System.out.print(li.poll()+" ");
			}
			System.out.println();
			
			
		}
	}
}
