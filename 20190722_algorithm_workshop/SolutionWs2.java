import java.util.Arrays;
import java.util.Scanner;


class Coordinate{
	int x;
	int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y= y;
	}
}

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
			
			y = Arrays.binarySearch(ladder[99], 2);
			
			point = dfs_recursion(99, y, "up");
			
			System.out.println("#"+tNum+" "+point);
		}
	}
	static int dfs_recursion(int x, int y, String dir) {
		//종료조건은? x가 0일때 y값?
		int nextX = x;
		int nextY = y;
		int ret;
		if(y < 0 || y > 99) return -1;
		
		if(dir.equals("up")) {
			while(nextX >= 0) {
				nextX--;
				if(y-1 >= 0 && ladder[nextX][y-1] == 1) {
					ret = dfs_recursion(nextX, nextY, "left");
					break;
				}else if(y+1 <=99 && ladder[nextX][y+1] == 1) {
					ret = dfs_recursion(nextX, nextY, "right");
					break;
				}else if(nextX == 0) return y;
			}
		}else if(dir.equals("left")) {
			while(nextY >= 0) {
				nextY--;
				if(x-1 >= 0 && ladder[x-1][nextY] == 1) {
					ret = dfs_recursion(nextX, nextY, "left");
					break;
				}else if(y+1 <=99 && ladder[nextX][y+1] == 1) {
					ret = dfs_recursion(nextX, nextY, "right");
					break;
				}else if(nextX == 0) return y;
			}
		}
		

		
		
		
		
		return 0;
	}


	

}
