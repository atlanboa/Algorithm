package 프로그래머스;

import java.util.*;

class Kakao_동굴탐험_dfs {
    static boolean[] visited = null;
    static int[] before = null;
    static int[] hang = null;
    static ArrayList<ArrayList<Integer>> graph;
    static Deque<Integer> queue;
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;

        visited = new boolean[n];
        before = new int[n];
        hang = new int[n];
        graph = new ArrayList<>();
        queue = new ArrayDeque<>();

        for (int[] od : order) {
            before[od[1]] = od[0];
        }

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : path) {
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        if(before[0] != 0) {
            return false;
        }

        visited[0] = true;
        for(int i=0; i<graph.get(0).size(); i++){
            queue.add(graph.get(0).get(i));
        }

        int target = 0;

        while(!queue.isEmpty()){

            target = queue.poll();

            if(visited[target]){
                continue;
            }
            if(!visited[before[target]]){
                hang[before[target]] = target;
                continue;
            }

            visited[target] = true;
            int size = graph.get(target).size();
            for(int i=0; i<size; i++){
                queue.addFirst(graph.get(target).get(i));
            }

            queue.addFirst(hang[target]);
        }

        for(int i=0; i<visited.length; i++){
            if(!visited[i]) return false;
        }

        return answer;
    }



    public static void main(String[] args) {
        int n = 9;
        int[][] path =
                {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order =
                {{8,5},{6,7},{4,1}};
        Kakao_동굴탐험_dfs t = new Kakao_동굴탐험_dfs();
        boolean answer = t.solution(n, path, order);
        System.out.println(answer);
    }
}