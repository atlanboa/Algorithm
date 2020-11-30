package 프로그래머스;

import java.util.*;

public class Kakao_다트게임 {
    public int solution(String dartResult) {
        int answer = 0;

        LinkedList<Integer> score = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int temp = 1;

        for(char d : dartResult.toCharArray()){

            if(Character.isDigit(d)){
                sb.append(d);
            }

            if(d == 'S' || d == 'D' || d == 'T'){
                temp = multiNumber(d, sb.toString());
                sb.delete(0, sb.length());
                score.add(temp);
            }

            if(d == '*' || d == '#'){
                if(d == '#'){
                    score.add(score.pollLast() * -1);
                }else{
                    int cur = score.pollLast();
                    if(score.size() > 0){
                        int ex = score.pollLast();
                        score.add(ex * 2);
                    }
                    score.add(cur * 2);
                }
            }
        }

        for(int s : score){
            answer += s;
        }

        return answer;
    }

    private int multiNumber(char d, String num) {
        int power = 1;
        if(d == 'D'){
            power = 2;
        }else if(d == 'T'){
            power = 3;
        }
        return (int) Math.pow(Integer.parseInt(num), power);
    }

    public static void main(String[] args) {
        Kakao_다트게임 temp = new Kakao_다트게임();

        String dartResult = "1S*2T*3S";
        int answer = temp.solution(dartResult);
        System.out.println(answer);
    }
}
