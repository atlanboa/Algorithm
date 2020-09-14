package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준12100_2048easy {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static final int DIRECTION = 4;
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    static int N;
    static int[][] map;
    static int max_block;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        max_block = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
                max_block = Math.max(map[i][j], max_block);
            }
        }

        solve(0, map);

        System.out.println(max_block);

    }

    private static void solve(int count, int[][] map) {
        if(count >= 5){
            return;
        }

        int[][] tempMap = new int[N][N];



        for(int dir=0; dir<DIRECTION; dir++){

            deepCopy(tempMap, map);

            move(dir, tempMap);


//            printMap(tempMap, count);

            solve(count+1, tempMap);

        }


    }

    private static void deepCopy(int[][] tempMap, int[][] map) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                tempMap[i][j] = map[i][j];
            }
        }

    }

    private static void printMap(int[][] map, int count){

        System.out.println((count+1)+"회 이동 ");
        for(int i=0; i<map.length; i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    private static void move(int dir, int[][] tempMap) {

        LinkedList<Integer> queue = new LinkedList<>();

        if(dir == UP){
            for(int j=0; j<N; j++){
                for(int i=0; i<N; i++){
                    if(tempMap[i][j] != 0){
                        queue.add(tempMap[i][j]);
                        tempMap[i][j] = 0;
                    }
                }
                int index = 0;
                while(!queue.isEmpty()){
                    int value =  queue.poll();
                    if(tempMap[index][j] == 0){
                        tempMap[index][j] = value;
                    }else{

                        if(tempMap[index][j] == value){
                            tempMap[index++][j] += value;
                            max_block = Math.max(max_block, tempMap[index-1][j]);
                        }else{
                            tempMap[++index][j] = value;
                        }
                    }
                }
            }

        }else if(dir == RIGHT){
            for(int i=0; i<N; i++){
                for(int j=N-1; j>=0; j--){
                    if(tempMap[i][j] != 0){
                        queue.add(tempMap[i][j]);
                        tempMap[i][j] = 0;
                    }
                }
                int index = N-1;
                while(!queue.isEmpty()){
                    int value =  queue.poll();
                    if(tempMap[i][index] == 0){
                        tempMap[i][index] = value;
                    }else{
                        if(tempMap[i][index] == value){
                            tempMap[i][index--] += value;
                            max_block = Math.max(max_block, tempMap[i][index+1]);
                        }else{
                            tempMap[i][--index] = value;
                        }
                    }
                }
            }
        }else if(dir == DOWN){
            for(int j=0; j<N; j++){
                for(int i=N-1; i>=0; i--){
                    if(tempMap[i][j] != 0){
                        queue.add(tempMap[i][j]);
                        tempMap[i][j] = 0;
                    }
                }
                int index = N-1;
                while(!queue.isEmpty()){
                    int value =  queue.poll();
                    if(tempMap[index][j] == 0){
                        tempMap[index][j] = value;
                    }else{

                        if(tempMap[index][j] == value){
                            tempMap[index--][j] += value;
                            max_block = Math.max(max_block, tempMap[index+1][j]);
                        }else{
                            tempMap[--index][j] = value;
                        }
                    }
                }
            }
        }else if(dir == LEFT){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(tempMap[i][j] != 0){
                        queue.add(tempMap[i][j]);
                        tempMap[i][j] = 0;
                    }
                }
                int index = 0;
                while(!queue.isEmpty()){
                    int value =  queue.poll();
                    if(tempMap[i][index] == 0){
                        tempMap[i][index] = value;
                    }else{
                        if(tempMap[i][index] == value){
                            tempMap[i][index++] += value;
                            max_block = Math.max(max_block, tempMap[i][index-1]);
                        }else{
                            tempMap[i][++index] = value;
                        }
                    }
                }
            }
        }

        /**
         * 0이 아닌 애들은 LinkedList 에 넣고 0으로 만들어줌
         *
         * 0이면 패스
         *
         * 다 넣고 나면 최초 인덱스부터 시작
         *
         * queue에서 한 개 뺌
         *
         * 1. 인덱스 해당 값이 0이면 넣음
         *
         * 2. 인덱스 해당 값이 0이 아니면 합쳐질 수 있는지 확인
         *
         * 3. 합치기 가능 ? 합치고 인덱스 이동
         * 4. 합치기 불가능 ? 인덱스 이동 후 삽입
         *
         * 5. queue가 empty 일때까지 반복
         *
         *
         */


    }

    /**
     * 4 x 4
     *
     * 상하좌우 이동
     *
     * 같은 값을 갖는 두 블록이 충돌하면 하나로 합쳐짐
     *
     * 한번의 이동에서 합쳐진 블록은 더 이상 합쳐질 수 없음 ( 다음 이동에서는 가능 )
     *
     * 최대 5번 이동해서 만들 수 있는 가장 큰 블록 값 구하기
     *
     *
     *
     */
}


//3
//2 2 2
//4 4 4
//8 8 8
//=> 16
//
//3
//2 2 2
//2 2 2
//2 2 2
//=>8
//
//10
//16 16 8 32 32 0 0 8 8 8
//16 0 0 0 0 8 0 0 0 16
//0 0 0 0 0 0 0 0 0 2
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//=>64
//
//5
//2 2 4 8 16
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//2 2 4 8 16
//=>64
//
//2
//16 0
//0 0
//=> 16
//
//7
//2 2 2 2 2 2 2
//2 0 2 2 2 2 2
//2 0 2 2 2 2 2
//2 0 2 2 2 2 2
//2 2 2 0 2 2 2
//2 2 2 2 2 2 0
//2 2 2 2 2 2 0
//=> 32
//
//10
//0 0 64 32 32 0 0 0 0 0
//0 32 32 64 0 0 0 0 0 0
//0 0 128 0 0 0 0 0 0 0
//64 64 128 0 0 0 0 0 0 0
//0 0 64 32 32 0 0 0 0 0
//0 32 32 64 0 0 0 0 0 0
//0 0 128 0 0 0 0 0 0 0
//64 64 128 0 0 0 0 0 0 0
//128 32 2 4 0 0 0 0 0 0
//0 0 128 0 0 0 0 0 0 0
//=> 1024
//
//20
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//=>32768
//
//
//3
//2 2 4
//0 0 0
//0 0 0
//=> 8
//
//2
//8 16
//16 8
//=>16
//
//4
//8 16 0 0
//0 0 16 8
//0 0 0 0
//0 0 0 0
//=>32
//
//4
//0 0 0 0
//4 0 0 0
//8 32 4 0
//8 8 4 0
//->64
//
//10
//
//8 8 4 16 32 0 0 8 8 8
//
//8 8 4 0 0 8 0 0 0 0
//
//16 0 0 16 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 16
//
//0 0 0 0 0 0 0 0 0 2
//=>128
//
//
//
//10
//
//0 0 0 0 0 32 8 64 8 16
//
//0 0 0 0 0 0 0 16 8 16
//
//0 0 0 0 0 0 0 0 0 2
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//=> 128
//
//
//
//1
//
//16
//
//=> 16
//
//2
//
//8 16
//
//16 8
//
//=>16
//
//
//
//4
//
//2 2 2 2
//
//2 2 2 2
//
//2 2 2 2
//
//2 2 2 2
//
//=>32