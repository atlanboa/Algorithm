package 프로그래머스;

import java.util.*;

public class Kakao_셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> passenger = new PriorityQueue<>();
        for(String time : timetable){
            int number =
                    (time.charAt(0) - '0') * 600 +
                    (time.charAt(1) - '0') * 60 +
                    (time.charAt(3) - '0') * 10 +
                    (time.charAt(4) - '0');
            passenger.add(number);
        }

        passenger.forEach(System.out::println);

        int busTime = 540;
        int last = 0;
        while(n --> 0){
            int accept = m;
            int time = 0;

            while(!passenger.isEmpty()){
                if(passenger.peek() <= busTime && accept > 0){
                    accept--;
                    time = passenger.poll();
                }else{
                    break;
                }
            }

            if(n > 0){
                busTime += t;
            }else{
                if(accept > 0){
                    last = busTime;
                }else{
                    last = time - 1;
                }
            }
        }

        answer = String.format("%02d:%02d", last / 60 , last % 60);
        return answer;
    }


    public static void main(String[] args) {
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timeTable = {"08:00", "08:01", "08:02", "08:03"};
        Kakao_셔틀버스 temp = new Kakao_셔틀버스();
        String answer = temp.solution(n, t, m, timeTable);
        System.out.println(answer);
    }
}
