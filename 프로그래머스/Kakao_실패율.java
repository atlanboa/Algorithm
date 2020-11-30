package 프로그래머스;

import java.util.*;

public class Kakao_실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] incomplete = new int[N+2];
        PriorityQueue<Result> list = new PriorityQueue<>();

        for(int s : stages){
            incomplete[s]++;
        }

        int total = stages.length;
        for(int i=1; i<N+1; i++){
            if(total != 0){
                list.add(new Result((float) incomplete[i] / total , i));
                total -= incomplete[i];
            }else{
                list.add(new Result(0, i));
            }
        }

        for(int i=0; i<N; i++){
            answer[i] = list.poll().stage;
            System.out.println(answer[i]);
        }

        return answer;
    }

    public class Result implements Comparable<Result>{
        float fail;
        int stage;

        public Result(float fail, int stage){
            this.fail = fail;
            this.stage = stage;
        }

        @Override
        public int compareTo(Result o) {
            int floatcompare =  Float.compare(o.fail, this.fail);
            if(floatcompare == 0){
                return Integer.compare(this.stage, o.stage);
            }
            return floatcompare;
        }

    }

    public static void main(String[] args) {
        Kakao_실패율 temp = new Kakao_실패율();

        int N = 4;
        int[] stages = {4,4,4,4,4};

        temp.solution(N, stages);
    }
}
