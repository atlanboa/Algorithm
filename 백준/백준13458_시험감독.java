package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 백준13458_시험감독 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;

    static int N;
    static int[] room;
    static int B, C;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        room = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            room[i]= Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long viewer = N;

        for(int i=0; i<N; i++){

            room[i] -= B;

            if(room[i] > 0){
                viewer += room[i] / C;

                if(room[i] % C != 0){
                    viewer++;
                }
            }
        }

        System.out.println(viewer);

    }

    /**
     * N개의 시험장
     *
     * i번 시험장에 있는 응시자 수는 Ai명
     *
     * 감독관 ( 총감독관, 부감독관 )
     *
     * 총감독관 감시 응시 대상 : B명
     * 부감독관 감시 응시 대상 : C명
     *
     * 총감독은 오직 1명 , 부감독은 여러명
     *
     * 모두 감시해야 하고 필요한 최소한의 감독관의 수를 작성
     *
     * dp문제도 아닌
     */
}
