import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution5643 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine().replaceAll(" ", ""));
		
		for(int t=1;t<=T;t++) {
			int N= Integer.parseInt(br.readLine().replaceAll(" ", ""));
			int M = Integer.parseInt(br.readLine().replaceAll(" ", ""));
			
			//index 1부터 시작이니깐 한 칸 더 크게
			ArrayList[] graph = new ArrayList[N+1];
			ArrayList[] graphRe = new ArrayList[N+1];
			for(int i=0; i<=N; i++) {
				graph[i] = new ArrayList<Integer>();
				graphRe[i] = new ArrayList<Integer>();
			}

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a, b;
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graphRe[b].add(a);
			}
			cnt = 0;
			for(int i=1; i<=N; i++) {
				dijkstra(i, graph, graphRe,N);
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
	static final int INF = Integer.MAX_VALUE;
	static int cnt;
	private static void dijkstra(int index, ArrayList[] graph, ArrayList[] graphRe, int N) {
		
		//dist 배열 초기화
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[index] = 0;
		
		//dijkstra queue
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(index);
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			int size = graph[temp].size();
			
			for(int i=0; i<size; i++) {
				
				int next = (int) graph[temp].get(i);
				
				if(dist[next] > dist[temp] + 1) {
					dist[next] = dist[temp]+1;
					queue.add(next);
				}
				
				
				
			}
				
		}
		
		queue.clear();
		queue.add(index);
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			int size = graphRe[temp].size();
			
			for(int i=0; i<size; i++) {
				
				int next = (int) graphRe[temp].get(i);
				
				if(dist[next] > dist[temp] + 1) {
					dist[next] = dist[temp]+1;
					queue.add(next);
				}
				
				
				
			}
				
		}
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(dist[i] != 0 && dist[i] != INF) {
				count++;
			}
		}
		
//		System.out.println(Arrays.toString(dist));
		if(count == N-1) {
			cnt++;
		}
	}
//	1      
//	6     
//	6      
//	1 5    
//	3 4    
//	5 4
//	4 2
//	4 6
//	5 2

}
