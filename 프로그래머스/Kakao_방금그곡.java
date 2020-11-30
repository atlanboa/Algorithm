package 프로그래머스;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Kakao_방금그곡 {
    public String solution(String m, String[] musicinfos) throws ParseException {

        String answer = "`(None)`";
        long maxPlayTime = 0;
        m = replaceSharp(m);

        for(int i=0; i< musicinfos.length; i++){
            String[] music = musicinfos[i].split(",");
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

            Date start = sdf.parse(music[0]);
            Date end = sdf.parse(music[1]);
            String title = music[2];
            long playTime = TimeUnit.MILLISECONDS.toMinutes(end.getTime() - start.getTime());
            String melody = makeMelody(music[3], playTime);

            if(melody.contains(m)){
                if(maxPlayTime < playTime){
                    answer = title;
                    maxPlayTime = playTime;
                }
            }

        }
        return answer;

    }

    private String makeMelody(String melody, long playTime) {
        melody = replaceSharp(melody);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<playTime; i++){
            sb.append(melody.charAt( i % melody.length()));
        }


        return sb.toString();
    }

    private String replaceSharp(String melody){
        melody = melody.replaceAll("A#", "a");
        melody = melody.replaceAll("C#", "c");
        melody = melody.replaceAll("D#", "d");
        melody = melody.replaceAll("F#", "f");
        melody = melody.replaceAll("G#", "g");
        return melody;
    }


    public static void main(String[] args) throws ParseException {
        Kakao_방금그곡 temp = new Kakao_방금그곡();
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        String result = temp.solution(m, musicinfos);
        System.out.println(result);
    }
}
