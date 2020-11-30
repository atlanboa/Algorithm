package 프로그래머스;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Kakao_압축 {
    public int[] solution(String msg) {
        int[] answer;
        LinkedList<Integer> result = new LinkedList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        initDic(dictionary);

        int index = 27;
        StringBuilder sb = new StringBuilder();

        for(char c: msg.toCharArray()){
            sb.append(c);
            if(dictionary.containsKey(sb.toString())) continue;
            else {
                result.add(dictionary.get(sb.substring(0, sb.length()-1)));
                dictionary.put(sb.toString(), index++);
                sb.delete(0, sb.length()-1);
            }
        }

        result.add(dictionary.get(sb.toString()));


        answer = result.stream().mapToInt(i->i).toArray();

//        for(char c = 'A'; c <= 'Z'; c++){
//            System.out.println(c+" key and value = " + dictionary.get(c+""));
//        }

        return answer;
    }

    private void initDic(Map<String, Integer> dictionary) {
        char start = 'A';
        for(int i=1; i<=26; i++){
            dictionary.put(start+"", i);
            start++;
        }
    }

    public static void main(String[] args) {
        Kakao_압축 temp = new Kakao_압축();
        int[] result = temp.solution("TOBEORNOTTOBEORTOBEORNOT");
        for(int i: result){
            System.out.println(i);
        }
    }
}
