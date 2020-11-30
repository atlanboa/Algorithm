package 프로그래머스;

import java.util.*;

public class Kakao_후보키 {
    public int solution(String[][] relation) {
        int answer;

        int attribute = relation[0].length;
        int tuple = relation.length;
        HashSet<String> set = new HashSet<>();
        HashSet<Integer> candidateKey = new HashSet<>();

        for(int i=1; i<(1<<attribute); i++){
            set.clear();

            for(int j=0; j<tuple; j++){
                StringBuilder key = new StringBuilder();
                for(int k=0; k<attribute; k++){
                    if( (i & (1<<k)) != 0){
                        key.append(relation[j][k]);
                    }
                }
//                System.out.println(key.toString());
                set.add(key.toString());
            }

            if(set.size() == tuple) pushOnlyMinimality(i, candidateKey);
        }

        answer = candidateKey.size();
//        System.out.println(answer);

        return answer;
    }

    private void pushOnlyMinimality(int newKey, HashSet<Integer> candidateKey) {
        for(int candidate: candidateKey){
            if( (candidate & newKey) == candidate){
                return;
            }
        }
        candidateKey.add(newKey);
    }


    public static void main(String[] args) {
        String[][] relation = 
                {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        Kakao_후보키 temp = new Kakao_후보키();
        temp.solution(relation);

    }
}
