
import java.util.LinkedList;
import java.util.Scanner;

public class Solution8189 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			
			int n, a, b;
			
			n = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			
			int[] letters = new int[n];
			
			int[] list = new int[1000];
			
			for(int i=0; i<n; i++) {
				
				letters[i] = sc.nextInt();
				 		  
			}
			
//			System.out.println(Arrays.toString(letters));
			//a개 이상이면 절반 확인하고 비움, 가장 오래 기다린 편지가 b시간 전에 온 편지면 우편함 비움
			
			
			int time = 0;
			int index = 0;
			int cnt = 0;
			int idxList = 0;
			while(idxList < n) {
				
				time++;
				cnt = chk(time, letters, index);
				if(time-letters[index]==b || cnt >= a) { //제일 오래 기다린 편지가 b시간 전에 온 편지라면?
					int nums = (int) (cnt/2.0+0.5);
					
					if(nums == 0) {
						list[idxList] = time;
						idxList++;
						break;
					}
					
					for(int i=0; i<nums; i++) {
						list[idxList] = time;
						idxList++;
					}
					
					index += nums;
					
				}
				
				
			}
			
			System.out.print("#"+t+" ");
			
			for(int i=0; i<idxList;i++) {
				System.out.print(list[i]+" ");
			}
			System.out.println();
		}
	}
	private static int chk(int time, int[] letters, int index) {
		//index 위치부터 time 보다 빨리 온 편지 개수 리턴
//		int size = letters.length - index; // 남은 메일 개수
		int cnt = 0;
		
		for(int i=index; i<letters.length; i++) {
			
			if(time >= letters[i]) {
				cnt++;
			}
			
		}
		
		
		return cnt;
	}

}
