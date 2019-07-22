import java.util.Scanner;

public class Cheese {
	static int testCase;
	static int[][] input;
	static int[][] check;
	static int[][] direction = {{0, 1},{1, 0},{0, -1},{-1, 0}};
	static int N;
	static int flavorMax, max;
	static int lumpCount;
	static int startI, startJ;
	static int allSameflavor;
	
	public static void init() {
		flavorMax = 0;
		lumpCount = 0;
		allSameflavor = 0;
		max = 0;
		check = new int[N+2][N+2];
		for(int i = 0; i < N + 2; i++) {
			for(int j = 0; j < N + 2; j++) {
				input[i][j] = -1;
			}
		}
	}
	
	public static void dfs(int i, int j, int day) {
		if(input[i][j] == day) {
			check[i][j] = -2;
			return;
		}
		if(check[i][j] == day || input[i][j] == -1 || check[i][j] == -2) return;
		check[i][j] = day;
		for(int k = 0; k < 4; k++) {
			int nextI = i + direction[k][0];
			int nextJ = j + direction[k][1];
			dfs(nextI, nextJ, day);
		}
		if(i == startI && j == startJ) lumpCount++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		for(int count = 0; count < testCase; count++) {
			N = sc.nextInt();
			input = new int[N+2][N+2];
			init();
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					input[i][j] = sc.nextInt();
					allSameflavor += input[i][j];
					if(flavorMax < input[i][j]) flavorMax = input[i][j];
				}
			}
			if(allSameflavor == N * N) max = 1;
			else {
				for(int i = 1; i <= flavorMax; i++) {
					for(int j = 1; j <= N; j++) {
						for(int k = 1; k <= N; k++) {
							startI = j;
							startJ = k;
							dfs(j,k,i);
						}	
					}
					if(max < lumpCount) max = lumpCount;
					lumpCount = 0;
				}
			}
			System.out.println("#" + (count+1) + " " + max);
		}
	
	}
}
