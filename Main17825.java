import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17825 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	static int[] ph = new int[4];
	static int[][] lookup ={
			//33점 0~32
			{1, 2, 3, 4, 5}, //0번째
			{2, 3, 4, 5, 6},
			{3, 4, 5, 6, 7},
			{4, 5, 6, 7, 8},
			{5, 6, 7, 8, 9},
			{21, 22, 23, 26, 30}, //5번째 ( 10 )
			{7, 8, 9, 10, 11},
			{8, 9, 10, 11, 12},
			{9, 10, 11, 12, 13},
			{10, 11, 12, 13, 14},
			{24, 25, 26, 30, 31}, //10번째 (20)
			{12, 13, 14, 15, 16},
			{13, 14, 15, 16, 17},
			{14, 15, 16, 17, 18},
			{15, 16, 17, 18, 19},
			{27, 28, 29, 26, 30},//15번째 (30)
			{17, 18, 19, 20, 32},
			{18, 19, 20, 32, 32},
			{19, 20, 32, 32, 32},
			{20, 32, 32, 32, 32},
			{32, 32, 32, 32, 32},//20번째
 			{22, 23, 26, 30, 31},
			{23, 26, 30, 31, 20},
			{26, 30, 31, 20, 32},
			{25, 26, 30, 31, 20},
			{26, 30, 31, 20, 32},//25번째
			{30, 31, 20, 32, 32},
			{28, 29, 26, 30, 31},
			{29, 26, 30, 31, 20},
			{26, 30, 31, 20, 32},
			{31, 20, 32, 32, 32},//30번째
			{20, 32, 32, 32, 32},
			{32, 32, 32, 32, 32}
			
	};
	
	//33개 0~32
	static int[] values = {
			0, 2, 4, 6, 8, 
			10, 12, 14, 16, 18, 
			20, 22, 24, 26, 28, 
			30, 32, 34, 36, 38, 
			40, 13, 16, 19, 22, 
			24, 25, 28, 27, 26, 
			30, 35, 0};
	static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		st = new StringTokenizer(br.readLine());
		numbers = new int[10];
		
		for(int i=0; i<10; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		//횟수(depth), 합
		
		dfs(0, 0);
		
		
		
		System.out.println(max);

		
	}
	static int max;
	private static void dfs(int depth, int sum) {
		
		if(depth == 10) {
			if(max < sum) {
				max = sum;
				
			}
			return;
		}
		
		//4개의 말이 가는 모든 경우를 보내줍니다.
		

		for(int i=0; i<4; i++) {
			
			//next는 현재 말의 위치에서 number[depth]-1을 움직였을때 가는 위치입니다.
			int ex = ph[i];
//			System.out.print(depth+" i="+i+" "+ph[i]+" "+numbers[depth]);
			
			int next = lookup[ph[i]][numbers[depth]-1];
//			System.out.println(" "+next+" sum="+sum);
			
			boolean flag = true;
			for(int j=0; j<4; j++) {
				
				if(next!=32 && ph[j]==next) {
					flag = false;
					break;
				}
				
			}
			
			if(flag) {
				//말을 위치를 옮겨주고
				ph[i] = next;
				//다음 주사위로 넘어갑니다.
				//현재 합에서 다음 주사위로 가는 합을 더해주고잉~
//				System.out.println(depth+" i="+i+" "+ph[i]+" "+numbers[depth]+" "+next+" sum="+(sum + values[next]));
				dfs(depth+1, sum + values[next]);
				
				//함수가 종료되었으면 돌아와서 이전 말 위치로 옮겨줍니다.
				ph[i] = ex;
			}
			
			
		}
		
	}
}
