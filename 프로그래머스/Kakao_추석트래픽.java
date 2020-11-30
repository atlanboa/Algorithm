package 프로그래머스;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Kakao_추석트래픽 {
    public int solution(String[] lines) {
        int answer = 0;
        Node[] array = new Node[lines.length];

        for(int i=0; i<lines.length; i++){
            String[] temp = lines[i].split(" ");
            String end = temp[0].concat(" ").concat(temp[1]);
            long start = (long) (Double.parseDouble(temp[2].replaceAll("s", ""))*1000);

            long endTime = getUnixTime(end);
            long startTime = endTime - start + 1;

            array[i] = new Node();
            array[i].startTime = startTime;
            array[i].endTime = endTime;
        }


        for(int i=0; i< array.length; i++){
            long start = array[i].startTime;
            long end = array[i].endTime;

            int startCnt = 0;
            int endCnt = 0;

            for(int j=0; j<array.length; j++){
                if(start <= array[j].endTime && array[j].startTime <= start + 999){
                    startCnt++;
                }
                if(end <= array[j].endTime && array[j].startTime <= end + 999){
                    endCnt++;
                }
            }

            answer = Math.max(answer, startCnt);
            answer = Math.max(answer, endCnt);
        }

        return answer;
    }

    public class Node implements Comparable<Node>{
        long startTime;
        long endTime;

        @Override
        public int compareTo(Node o) {

            return Long.valueOf(startTime).compareTo(o.startTime);
        }
    }

    public long getUnixTime(String timeStamp){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date dt = null;
        try {
            dt = sdf.parse(timeStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long epoch = dt.getTime();
        return epoch;
    }

    public static void main(String[] args) {
        String[] lines =
                {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};

        String[] lines2 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        Kakao_추석트래픽 temp = new Kakao_추석트래픽();
        int cnt = temp.solution(lines2);
        System.out.println(cnt);
    }
}
