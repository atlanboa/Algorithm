import java.util.Scanner;


public class SolutionWs2 {
	static int[][] ladder = new int[100][100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		int y=0;
		
		for(int t=1; t<=T; t++) {
			int tNum = sc.nextInt();
			int point = -1;
			//출발점 x반환
			for(int row=0; row<100; row++) {
				for(int col=0; col<100; col++) {
					ladder[row][col] = sc.nextInt();
				}
			}
			
			for(int i=0; i<100; i++) {
				if(ladder[99][i]==2) y = i;
			}
			point = dfs_recursion(99, y, "up");
			
			System.out.println("#"+tNum+" "+point);
		}
	}
	static int dfs_recursion(int x, int y, String dir) {
		//종료조건은? x가 0일때 y값?
		int nextX = x;
		int nextY = y;
		if(x == 0) return y;
		
		if(dir.equals("up")) {
			while(nextX >= 0) {
//				System.out.println("x : "+nextX +" y: "+nextY);
				if(y-1 >= 0 && ladder[nextX][y-1] == 1) {
					return dfs_recursion(nextX, y-1, "left");
					
				}else if(y+1<=99 && ladder[nextX][y+1] == 1) {
					return dfs_recursion(nextX, y+1, "right");
				}else if(nextX==0) return y;
				else nextX--;
			}
		}else if(dir.equals("left")) {
			while(nextY >= 0) {
				
				if(x-1 >= 0 && ladder[x-1][nextY] == 1) {
					return dfs_recursion(x-1, nextY, "up");
				}else if(nextX==0) return y;
				else nextY--;
			}
		}else {
			while(nextY <= 99) {
				
				if(x-1 >= 0 && ladder[x-1][nextY] == 1) {
					return dfs_recursion(x-1, nextY, "up");
				}else if(nextX==0) return y;
				else nextY++;
			}
			
		}
		

		
		return 0;
	}


	

}
