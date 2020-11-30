package 백준;

import java.io.*;
import java.util.*;

public class 백준3190_뱀 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;

    static final int  APPLE = 1;
    static final int SNAKE = 2;

    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;


    static int N, K, L;
    static int[][] map;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


//            System.out.println(x+" "+ y);

            map[x-1][y-1] = APPLE;
        }

        LinkedList<SnakeBlock> snake = new LinkedList<>();
        snake.add(new SnakeBlock(0, 0));
        map[0][0] = SNAKE;

        L = Integer.parseInt(br.readLine());

        Map<Integer, Character> cmdMap = new HashMap<>();

        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char command = st.nextToken().charAt(0);

            cmdMap.put(time, command);
        }


        int endTime = 0;
        int direction = RIGHT;
        out:
        while (true) {
//            System.out.println(endTime + " " + snake.peekLast().x + " " + snake.peekLast().y);
//            printMap();

            endTime++;

            int nx = snake.peekLast().x + dx[direction];
            int ny = snake.peekLast().y + dy[direction];

            if (!(0 <= nx && nx < N && 0 <= ny && ny < N) || map[nx][ny] == SNAKE) {
                break out;
            }

            if (map[nx][ny] == APPLE) {
                map[nx][ny] = SNAKE;
                snake.add(new SnakeBlock(nx, ny));
                if(cmdMap.containsKey(endTime)){
                    direction = getDirection(direction, cmdMap.get(endTime));
                }
                continue;
            }

            map[nx][ny] = SNAKE;
            snake.add(new SnakeBlock(nx, ny));
            SnakeBlock sb = snake.poll();
            map[sb.x][sb.y] = 0;

            if(cmdMap.containsKey(endTime)){
                direction = getDirection(direction, cmdMap.get(endTime));
            }


        }

        System.out.println(endTime);

    }

    private static void printMap(){
        for(int i=0; i<N; i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }

    private static int getDirection(int currentDirection, char command){
        int nextDirection;

        switch (command) {
            case 'L' :
                nextDirection = currentDirection - 1;
                if (nextDirection < 0) return LEFT;
                else return nextDirection;
            case 'D' :
                nextDirection = currentDirection + 1;
                if (nextDirection > 3) return UP;
                else return nextDirection;

        }


        return 0;

    }

    public static class SnakeBlock{
        int x, y;

        public SnakeBlock(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    /**
     * 뱀 게임
     *
     * 벽 또는 자기 자신과 부딪히면 게임 끝
     *
     * 시작 뱀 길이 1
     *
     * 처음은 오른쪽 방향
     *
     * 사과를 먹으면 몸 1칸 길어짐
     *
     * 이동 규칙
     * 1. 몸 길이를 늘려서 다음칸에 위치
     * 2. 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않음
     * 3. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.
     *
     * 사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는가?
     *
     * N 보드 크기
     * K 사과의 개수
     *
     * K 줄 : 사과의 위치
     *
     * L 뱀위 방향 변환 횟수
     *
     * X, C
     *
     * X = x초 후
     * C = L or D  L  = 왼쪽 90도 , D = 오른쪽 90도
     *
    */
}
