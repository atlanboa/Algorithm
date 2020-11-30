package 프로그래머스;

import java.util.LinkedList;

public class Kakao_캐시 {
    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;
    public int solution(int cacheSize, String[] cities) {
        int answer;
        LinkedList<String> cache = new LinkedList<>();
        int runningTime = 0;

        for(int i = 0; i<cities.length; i++){
            cities[i] = cities[i].toLowerCase();
        }

        if(cacheSize == 0){
            return CACHE_MISS * cities.length;
        }

        for(String city : cities){
            if(cache.contains(city)){
                cache.remove(city);
                cache.add(city);
                runningTime += CACHE_HIT;
//                System.out.println("CACHE HIT with "+ city);
            }else{
                if (cache.size() >= cacheSize) {
                    cache.poll();
                }
                cache.add(city);
//                System.out.println("CACHE MISS with "+ city);
                runningTime += CACHE_MISS;
            }
        }

        answer = runningTime;

        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities =
                {
                "Jeju",
                "Pangyo",
                "Seoul",
                "NewYork",
                "LA",
                "Jeju",
                "Pangyo",
                "Seoul",
                "NewYork",
                "LA"};
        int result = 50;

        Kakao_캐시 temp = new Kakao_캐시();
        int answer = temp.solution(cacheSize, cities);

        if(result == answer) System.out.println("정답입니다!!");

    }
}
