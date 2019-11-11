import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution5644 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	static class Node {
		int x, y;
		int c;
		int p;

		public Node(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int m, a;
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			Node[] aop = new Node[a];

			int[] moveA = new int[m+1];
			int[] moveB = new int[m+1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				int x, y, p, c;
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				aop[i] = new Node(x-1, y-1, c, p);
			}

			Node posA = new Node(0, 0, 0, 0);
			Node posB = new Node(9, 9, 0, 0);
			for (int i = 0; i <= m; i++) {



//				System.out.println("t:"+i+" "+posA.x+","+posA.y+" "+posB.x+","+posB.y);
				// A가 속해있는 aop
				ArrayList<Integer> aopA = new ArrayList<>();
				// B가 속해있는 aop
				ArrayList<Integer> aopB = new ArrayList<>();

				for (int j = 0; j < aop.length; j++) {
					// 각각의 A, B의 모든 aop들과의 거리
					int disA = Math.abs(posA.x - aop[j].x) + Math.abs(posA.y - aop[j].y);
					int disB = Math.abs(posB.x - aop[j].x) + Math.abs(posB.y - aop[j].y);

					// A가 속한 aop
					if (disA <= aop[j].c) {
						aopA.add(j);
					}
					// B가 속한 aop
					if (disB <= aop[j].c) {
						aopB.add(j);
					}
				}
				// A움직이고
				posA.x += dx[moveA[i]];
				posA.y += dy[moveA[i]];
				// B움직이고
				posB.x += dx[moveB[i]];
				posB.y += dy[moveB[i]];
				if (aopA.size() == 0 && aopB.size() == 0)
					continue;
				else if (aopA.size() > 0 && aopB.size() > 0) {
					int max = Integer.MIN_VALUE;
					int plusA = 0;
					int plusB = 0;
					for (int j = 0; j < aopA.size(); j++) {
						for (int k = 0; k < aopB.size(); k++) {
							int curAopA = aopA.get(j);
							int curAopB = aopB.get(k);

							// 두 aop의 인덱스가 같은 경우
							if (curAopA == curAopB) {
								if (max < aop[curAopA].p / 2 + aop[curAopB].p / 2) {
									plusA = aop[curAopA].p / 2;
									plusB = aop[curAopB].p / 2;
									max = plusA + plusB;
								}
							}else {
								if (max < aop[curAopA].p + aop[curAopB].p) {
									plusA = aop[curAopA].p;
									plusB = aop[curAopB].p;
									max = plusA + plusB;
								}
							}

						}
					}
//					System.out.println(max);
					posA.p += plusA;
					posB.p += plusB;
					
				}else if(aopA.size() > 0){
					int max = Integer.MIN_VALUE;
					for(int j=0; j<aopA.size(); j++) {
						int curAopA = aopA.get(j);
						
						if(max < aop[curAopA].p) {
							max = aop[curAopA].p;
						}
					}
//					System.out.println(max);
					posA.p += max;
				}else {
					int max = Integer.MIN_VALUE;
					for(int j=0; j<aopB.size(); j++) {
						int curAopB = aopB.get(j);
						
						if(max < aop[curAopB].p) {
							max = aop[curAopB].p;
						}
					}
//					System.out.println(max);
					posB.p += max;
				}
				

				
				
			}
			
			System.out.println("#"+t+" "+(posA.p+posB.p));

		}

	}

}
