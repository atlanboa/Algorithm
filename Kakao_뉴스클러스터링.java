import java.util.LinkedList;
import java.util.List;

public class Kakao_뉴스클러스터링 {
    static final int STANDARD_NUMBER = 65536;
    public int solution(String str1, String str2) {

        List<String> set1 = new LinkedList<>();
        List<String> set2 = new LinkedList<>();

        makeSet(set1, str1);
        makeSet(set2, str2);

        List<String> union = new LinkedList<>();
        union.addAll(set1);
        union.addAll(set2);

        List<String> intersection = new LinkedList<>();
        makeIntersection(intersection, set1, set2);



        int unionSize = union.size() - intersection.size();
        int intersectionSize = intersection.size();
        double result = ((double) intersectionSize / unionSize) * STANDARD_NUMBER;

        if(unionSize == 0 && intersectionSize == 0){
            return STANDARD_NUMBER;
        }

        return (int) result;
    }

    private void makeIntersection(List<String> intersection, List<String> set1, List<String> set2) {
        for(String s: set1){
            if(set2.contains(s)){
                set2.remove(s);
                intersection.add(s);
            }
        }
    }

    private void makeSet(List<String> set, String str) {
        for(int i=0; i<str.length()-1; i++){
            String temp = str.substring(i, i+2);
            if(isOnlyAlpha(temp)){
                set.add(temp.toLowerCase());
            }
        }
    }

    public static boolean isOnlyAlpha(String str){
        return Character.isAlphabetic(str.charAt(0)) && Character.isAlphabetic(str.charAt(1));
    }

    public static void main(String[] args) {
        String str1 =
                "aa1+aa2";
//                "FRANCE";
        String str2 =
                "AAAA12";
//                "french";
        int result = 43690;

//                16384;

        Kakao_뉴스클러스터링 t = new Kakao_뉴스클러스터링();
        int answer = t.solution(str1, str2);
        if(result == answer){
            System.out.println("correct answer");
        }

    }
}
