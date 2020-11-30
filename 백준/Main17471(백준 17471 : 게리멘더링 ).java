package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main17471 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int n;
	static int[] area;
	static int[][] graphArr;
	static ArrayList[] graph;

	public static void main(String[] args) throws Exception {

		// 입력 n
		n = Integer.parseInt(br.readLine());
		// n배열 선언
		area = new int[n];
		// 그래프 생성
		graph = new ArrayList[n];
		graphArr = new int[n][n];
		min = Integer.MAX_VALUE;
		p = new int[n];

		/*
		 * input 6 5 2 3 4 1 2 2 2 4 4 1 3 6 5 2 4 2 2 1 3 1 2 1 2
		 * 
		 */

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			area[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<Integer>();
		}
//		System.out.println(Arrays.toString(area));
		int rep = 0;
		int to = 0;
		for (int from = 0; from < n; from++) {
			st = new StringTokenizer(br.readLine());
			rep = Integer.parseInt(st.nextToken());

			for (int j = 0; j < rep; j++) {
				to = Integer.parseInt(st.nextToken());
				graph[from].add(to - 1);
				graphArr[from][to - 1] = 1;
				graphArr[to - 1][from] = 1;
			}

		}

//		for (int i = 0; i < n; i++) {
//			int size = graph[i].size();
//			for (int j = 0; j < size; j++) {
//				System.out.print(graph[i].get(j) + " ");
//			}
//			System.out.println();
//		}
//		
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(graphArr[i]));
//		}

		run();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	/*
	 * 백준시는 N개의 구역으로 나누어져 있고, 구역은 1번부터 N번까지 번호가 매겨져 있다. 구역을 두 개의 선거구로 나눠야 하고, 각 구역은
	 * 두 선거구 중 하나에 포함되어야 한다. 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결되어 있어야
	 * 한다. 구역 A에서 인접한 구역을 통해서 구역 B로 갈 수 있을 때, 두 구역은 연결되어 있다고 한다. 중간에 통하는 인접한 구역은 0개
	 * 이상이어야 하고, 모두 같은 선거구에 포함된 구역이어야 한다. 아래 그림은 6개의 구역이 있는 것이고, 인접한 구역은 선으로 연결되어
	 * 있다.
	 * 
	 * 첫째 줄에 구역의 개수 N이 주어진다. 둘째 줄에 구역의 인구가 1번 구역부터 N번 구역까지 순서대로 주어진다. 인구는 공백으로 구분되어져
	 * 있다. 셋째 줄부터 N개의 줄에 각 구역과 인접한 구역의 정보가 주어진다. 각 정보의 첫 번째 정수는 그 구역과 인접한 구역의 수이고,
	 * 이후 인접한 구역의 번호가 주어진다. 모든 값은 정수로 구분되어져 있다. 구역 A가 구역 B와 인접하면 구역 B도 구역 A와 인접하다.
	 * 인접한 구역이 없을 수도 있다.
	 */
	static int min;

	private static void run() {
		// n개 중에 몇개만 골라서 연결된지 확인하고

		int rep = (1 << n) / 2;
		ArrayList<Integer> group1 = new ArrayList<Integer>();
		ArrayList<Integer> group2 = new ArrayList<Integer>();
		boolean flag1, flag2;
		int sum1, sum2;
		for (int i = 0; i < rep; i++) {
			// 그룹 나누고
			sum1 = 0;
			sum2 = 0;
			flag1 = false;
			flag2 = false;
			group1.clear();
			group2.clear();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					group1.add(j);
				} else {
					group2.add(j);
				}
			}
			// 각각의 그룹의 노드들이 모두 연결된지 확인하고 둘다 연결되어있으면 합을 구해서 차를 리턴
			if (group1.size() == 0 || group2.size() == 0) {
				continue;
			}
//			System.out.print("group1 :: ");
//			for (int j = 0; j < group1.size(); j++) {
//				System.out.print(group1.get(j) + " ");
//			}
//			System.out.print("group2 :: ");
//			for (int j = 0; j < group2.size(); j++) {
//				System.out.print(group2.get(j) + " ");
//			}

			flag1 = check(group1);
			flag2 = check(group2);

			if (flag1 && flag2) {

				for (int j = 0; j < group1.size(); j++) {
					sum1 += area[group1.get(j)];
				}

				for (int j = 0; j < group2.size(); j++) {
					sum2 += area[group2.get(j)];
				}

				int sub = Math.abs(sum1 - sum2);

				if (min > sub) {
					min = sub;
				}

//				System.out.println(" sub :: " + sub);

			} 
//			else {
//				System.out.println(" 연결되지 않음 " + flag1 + " " + flag2 + " " + Arrays.toString(p));
//			}

		}

	}

	static int[] p;

	private static boolean check(ArrayList<Integer> group) {
		// TODO Auto-generated method stub
		// 0, 2, 3
//		System.out.println();
		int size = group.size();
		makeSet();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j)
					continue;

				int nodeA = group.get(i);
				int nodeB = group.get(j);
				
//				System.out.println(nodeA+" "+nodeB);

				// nodeA와 nodeB가 연결되어있으면
				if (graphArr[nodeA][nodeB] == 1) {
					unionSet(nodeA, nodeB);
				}

			}
		}
		refindSet(group);
//		System.out.println(Arrays.toString(p));
		boolean flag = true;
		int parent = p[group.get(0)];
		for (int i = 0; i < size; i++) {
			if (p[group.get(i)] != parent) {
				flag = false;
				break;
			}
		}

		return flag;
	}

	private static void refindSet(ArrayList<Integer> group) {
		for (int i = 0; i < group.size(); i++) {
			findSet(group.get(i));
		}
	}

	private static void makeSet() {
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}

	}

	private static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);

		if (x == y) {
			return;
		}

		p[y] = x;

	}

	private static int findSet(int x) {
		if (x == p[x])
			return x;
		int idx = findSet(p[x]);
		p[x] = idx;
		return idx;
	}

}
