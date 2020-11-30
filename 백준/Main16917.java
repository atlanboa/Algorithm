package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class Main16917 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	/*
	 * 반반 = 후라이드반 양념반
	 * 양념 치킨 한마리의 가격 A원
	 * 후라이드 치킨 한마리의 가격  B원
	 * 반반 치킨 C원
	 * 파티에 양념 치킨 최소 X마리 후라이드 최소 Y마리를 구매.
	 * 반반 치킨을 두마리 구입해 후라이드 한마리 양념 한마리를 만드는것도 가능
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		//입력 A, B, C, X, Y
		long  A, B, C, X, Y;
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		//반반을 사는게 이득인지, 그냥 사는게 이득인지 확인
		long money = 0;
		//
		money += X>Y?Math.min(A*Y+B*Y, (C+C)*Y)  
				:  Math.min(A*X+B*X, (C+C)*X) ;
		
		money += X>Y?Math.min((C+C)*(X-Y), A*(X-Y)):Math.min((C+C)*(Y-X), B*(Y-X));
		
		System.out.println(money);

	}
}
