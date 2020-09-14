package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준13460_구슬탈출2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;


    static int N, M;
    static char[][] map;
    static Ball blue;
    static Ball red;
    static int min;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = temp.charAt(j);

                if(map[i][j] == 'B'){
                    blue = new Ball(i, j);
                    map[i][j] = '.';
                }

                if(map[i][j] == 'R'){
                    red = new Ball(i, j);
                    map[i][j] = '.';
                }

            }
        }


        solve(0, blue.x, blue.y, red.x, red.y);

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }

    }

    private static void printMap(){
        for(int i=0; i<N; i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }

    private static void solve(int count, int bx, int by, int rx, int ry) {
        if(count >= min | count > 10){
            return;
        }

        if(blue.out){
            return;
        }

        if(red.out){
            min = count;
            return;
        }

        for(int i=0; i<4; i++){

            blue.setBall(bx, by);
            red.setBall(rx, ry);
            blue.out = false;
            red.out = false;

            move(i);

            solve(count + 1, blue.x, blue.y, red.x, red.y);


        }

    }

    private static void move(int dir) {

        int blueMoveCnt = 0;
        int redMoveCnt = 0;

        while(!blue.out){
            int nx = blue.x + dx[dir];
            int ny = blue.y + dy[dir];

            if(map[nx][ny] == '#'){
                break;
            }
            else if(map[nx][ny] == 'O'){
                blue.out = true;
            }

            blue.setBall(nx, ny);
            blueMoveCnt++;

        }

        if(blue.out) return;

        while(!red.out){
            int nx = red.x + dx[dir];
            int ny = red.y + dy[dir];

            if(map[nx][ny] == '#'){
                break;
            }
            else if(map[nx][ny] == 'O'){
                red.out = true;
            }
            red.setBall(nx, ny);
            redMoveCnt++;
        }

        if (compareBall(blue, red) && map[blue.x][blue.y] != 'O') {
            int pre_nx;
            int pre_ny;
            if (blueMoveCnt > redMoveCnt) {
                pre_nx = blue.x - dx[dir];
                pre_ny = blue.y - dy[dir];

                blue.setBall(pre_nx, pre_ny);
            } else {
                pre_nx = red.x - dx[dir];
                pre_ny = red.y - dy[dir];

                red.setBall(pre_nx, pre_ny);
            }
        }


    }

    private static boolean compareBall(Ball blue, Ball red) {
        if(blue.x == red.x & blue.y == red.y) return  true;
        else return false;
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static class Ball {
        int x;
        int y;
        boolean out;

        public Ball(int x, int y){
            this.x = x;
            this.y = y;
            this.out = false;
        }

        public void setBall(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

}
