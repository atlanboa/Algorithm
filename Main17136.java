import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main17136 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static char[][] paper;
	static int[] colorPaper = {0, 5, 5, 5, 5, 5};
	static int count;
	public static void main(String[] args) throws Exception{
		
		/*
		 * 색종이의 크기는 1×1, 2×2, 3×3, 4×4, 5×5로 총 다섯 종류가 있으며, 각 종류의 색종이는 5개
		 * 칸의 경계와 일치하게 붙여야 한다. 0이 적힌 칸에는 색종이가 있으면 안 된다.
		 *  1이 적힌 칸은 모두 색종이로 덮여져야 한다.
		 * 1이 적힌 모든 칸을 붙이는데 필요한 색종이의 최소 개수
		 * 모든 1을 덮는데 필요한 색종이의 최소 개수를 출력한다. 1을 모두 덮는 것이 불가능한 경우에는 -1을 출력한다
		 */
		
		count = 0;
		min = Integer.MAX_VALUE;
		paper = new char[10][10];
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				paper[i][j] = st.nextToken().charAt(0);
				if(paper[i][j]=='1') count++;
			}
		}
		
		//
		run();
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	
	private static void run() {
		
		cnt = 0;
		func(0, 0);
		
	}
	static int cnt;
	private static void func(int x, int y) {
		
		//마지막까지 확인하고 내려 오면?
		if(x==10) {
			//종이 갯수 확인
			min = Math.min(min, cnt);
			return;
		}
		
		//y가 끝까지 가면 다음줄로
		if(y==10) {
			func(x+1, 0);
			return;
		}
		

		//현재 칸이 0이면 다음칸으로
		if(paper[x][y] == '0') {
			func(x, y+1);
			return;
		}
		
		//색칠해야되는 종이면?
		for(int size=5; size>=1; size--) {
			
			//남은 색종이가 없거나 붙이면 범위를 넘어가는 애들은 패스
			if(colorPaper[size] == 0 || x + size > 10 || y + size > 10) {
				continue;
			}
			
			//정사각형 체크
			boolean flag = true;
			out : for(int i=x; i<x+size; i++) {
				for(int j=y; j<y+size; j++) {
					
					if(paper[i][j]=='0') {
						flag = false;
						break out;
					}
					
				}
			}
			
			//없으면 패스
			if(!flag) {
				continue;
			}
			
			//있으면?
			if(flag) {
				
				//덮어주고
				for(int i=x; i<x+size; i++) {
					for(int j=y; j<y+size; j++) {
						paper[i][j] = '0';
					}
				}
				
				cnt++;
				colorPaper[size]--;
				
				func(x, y+size);
				
				
				//다시 돌려주고
				for(int i=x; i<x+size; i++) {
					for(int j=y; j<y+size; j++) {
						paper[i][j] = '1';
					}
				}
				
				cnt--;
				colorPaper[size]++;
				
				
			}
		}
		//y칸을 움직이면서 체크
		
		
	}

	static int min;
	/*
	 * 5개로 붙이고 안되면
	 * 4개로 붙이고 안되면
	 * 3개로 붙이고 안되면
	 * 2개로 붙이고 안되면
	 * 1개로 붙이고 
	 * 최소값 찾을때까지 완탐
	 * count가 0개면 모두 붙인거고
	 * 각 종이는 5장씩 
	 */
}
