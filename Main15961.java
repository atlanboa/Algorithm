import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main15961 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	/*
	 * 회전하는 벨트에 초밥이 있고 손님은 이 중에서 좋아하는 초밥을 골라먹는다.
	 * 초밥의 종류는 번호로 표현, 벨트 위에 같은 종류의 초밥이 둘 이상 있을수도 있음
	 * 이벤트
	 * 1. 임의의 한 위치부터 K개의 접시를 연속해서 먹는 경우 할인된 정액 가격
	 * 2. 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행되고 이 쿠폰은 1번을 참석할때 초밥 
	 * 한개를 무료로 받는 쿠폰, 벨트위에 없는 경우 직접 만들어 제공
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		//회전 초밥 음식점의 벨트 상태, 메뉴에 있는 초밥의 가짓수
		//연속해서 먹는 접시의 개수, 쿠폰 번호
		//손님이 먹을 수 있는 초밥 가짓수의 최대값?
		//회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
		TreeSet<Integer> set = new TreeSet<>();
		int N, d, k, c;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int[] belt = new int[N];
		int[] chobob = new int[d+1];
		
		for(int i=0; i<N; i++) {
			belt[i]=Integer.parseInt(br.readLine());
		}
		int max = 0;
		int cnt = 0;
		for(int i=0; i<k; i++) {
			chobob[belt[i]]++;
			
			if(chobob[belt[i]]==1) {
				cnt++;
			}
			
		}

		if(chobob[c]++==0) cnt++;  
		
		
		for(int i=0; i<N; i++) {
			chobob[belt[i]]--;
			if(chobob[belt[i]] == 0) {
				cnt--;
			}
			
			chobob[belt[(i+k)%N]]++;
			if(chobob[belt[(i+k)%N]]==1) {
				cnt++;
			}
			
			if(max < cnt) max = cnt;
			
		}
		System.out.println(max);

	}
}
