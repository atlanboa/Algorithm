import java.util.Scanner;

public class Puzzle {
	static int N, K;
	static int testCase;
	static int[][] input;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		for(int count = 0; count < testCase; count++) {
			N = sc.nextInt();
			K = sc.nextInt();
			input = new int[N + 2][N + 2];
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					input[i][j] = sc.nextInt();
			
			int flag = 0;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N-(K-1); j++) {
					int sum = 0;
					for(int k = 0; k < K; k++) {
						sum += input[i][j + k];
					}
					if(sum == K && (input[i][j - 1] == -1 || input[i][j - 1] == 0) && (input[i][j + K] == -1 || input[i][j + K] == 0)) {
						flag++;
					}
				}
				for(int j = 1; j <= N-(K-1); j++) {
					int sum = 0;
					for(int k = 0; k < K; k++) {
						sum += input[j + k][i];
					}
					if(sum == K && (input[j - 1][i] == -1 || input[j - 1][i] == 0) && (input[j + K][i] == -1 || input[j + K][i] == 0)) {
						flag++;
					}
				}
			}
			System.out.println("#" + (count+1) + " " + flag);
		}
	}

}
