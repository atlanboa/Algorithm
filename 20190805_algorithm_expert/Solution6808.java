import java.util.Scanner;

public class Solution6808 {
	static int cntWin;
	static int cntLose;
	static int[] cardA = null;
	static int[] cardB = null;
	static boolean[] visited = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			cardA = new int[9];
			cardB = new int[9];
			boolean[] nums = new boolean[18];
			cntWin = 0;
			cntLose = 0;
			visited = new boolean[9];
			for (int i = 0; i < cardA.length; i++) {
				cardA[i] = sc.nextInt();
				nums[cardA[i]-1] = true;
			}
			int index = 0;
			for(int i=0; i<18; i++) {
				if(!nums[i]) {
					cardB[index] = i+1;
					index++;
				}
				
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#"+t+" "+cntWin+" "+cntLose);
			
		}

	}
	
	static void dfs(int index, int sumA, int sumB) {
		if(sumA > 171) {
			cntWin++;
			return ;
		}
		if(sumB > 171) {
			cntLose++;
			return;
		}
		if(index == 9) {
			if(sumA > sumB) {
				cntWin++;
			}else {
				cntLose++;
			}
			return;
		}
		
		
		for(int i=0; i<9; i++) {
			
			if(!visited[i]) {
				visited[i] = true;
				if(cardA[index]>cardB[i]) {
					dfs(index+1, sumA + cardA[index]+ cardB[i], sumB);	
				}else {
					dfs(index+1, sumA , sumB + cardA[index]+ cardB[i]);
				}
				visited[i] = false;
			}else {
				continue;
			}
			
			
		}
		
		
		
	}
	
}

