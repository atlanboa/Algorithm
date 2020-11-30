package 프로그래머스;

import java.util.LinkedList;

public class Kakao_프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        Block[][] map = new Block[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<board[i].length(); j++){
                map[i][j] = new Block();
                map[i][j].flag = false;
                map[i][j].type = board[i].charAt(j);
            }
        }
        while(true){
            // find
            findCube(map);
            // delete
            int deletedCube = deleteCube(map, m, n);
            if(deletedCube == 0) break;
            answer += deletedCube;
            // down
            downCube(map, m , n);
        }


        return answer;
    }

    private void downCube(Block[][] map, int m, int n) {
        LinkedList<Block> list = new LinkedList<>();
        for(int j=0; j<n; j++){
            for(int i=0; i<m; i++){
                if(map[i][j].type != '0'){
                    Block temp = new Block(false, map[i][j].type);
                    list.add(temp);
                    map[i][j].type = '0';
                }
            }

            int index = m -1;
            while(!list.isEmpty()){
                Block temp = list.pollLast();
                map[index][j].type = temp.type;
                index--;
            }

        }
    }

    private int deleteCube(Block[][] map, int m, int n) {
        int cnt = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j].flag){
                    map[i][j].type = '0';
                    cnt++;
                }
                map[i][j].flag = false;
            }
        }
        return cnt;

    }

    private void findCube(Block[][] map) {

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                // 4 way find
                // left upper
                if(map[i][j].type == '0') continue;

                try{
                    int x1, y1, x2, y2, x3, y3;
                    x1 = i -1;
                    y1 = j -1;
                    x2 = i -1;
                    y2 = j;
                    x3 = i;
                    y3 = j-1;

                    if(map[i][j].type == map[x1][y1].type &&
                        map[i][j].type == map[x2][y2].type &&
                        map[i][j].type == map[x3][y3].type){
                        map[i][j].flag = true;
                        map[x1][y1].flag = true;
                        map[x2][y2].flag = true;
                        map[x3][y3].flag = true;
                    }

                }catch (Exception ignored){}

                //right upper
                try{
                    int x1, y1, x2, y2, x3, y3;
                    x1 = i -1;
                    y1 = j;
                    x2 = i -1;
                    y2 = j + 1;
                    x3 = i;
                    y3 = j + 1;

                    if(map[i][j].type == map[x1][y1].type &&
                            map[i][j].type == map[x2][y2].type &&
                            map[i][j].type == map[x3][y3].type){
                        map[i][j].flag = true;
                        map[x1][y1].flag = true;
                        map[x2][y2].flag = true;
                        map[x3][y3].flag = true;
                    }

                }catch (Exception ignored){}

                //left under
                try{
                    int x1, y1, x2, y2, x3, y3;
                    x1 = i;
                    y1 = j -1;
                    x2 = i + 1;
                    y2 = j - 1;
                    x3 = i + 1;
                    y3 = j;

                    if(map[i][j].type == map[x1][y1].type &&
                            map[i][j].type == map[x2][y2].type &&
                            map[i][j].type == map[x3][y3].type){
                        map[i][j].flag = true;
                        map[x1][y1].flag = true;
                        map[x2][y2].flag = true;
                        map[x3][y3].flag = true;
                    }

                }catch (Exception ignored){}

                //right under
                try{
                    int x1, y1, x2, y2, x3, y3;
                    x1 = i;
                    y1 = j +1;
                    x2 = i +1;
                    y2 = j;
                    x3 = i +1;
                    y3 = j+1;

                    if(map[i][j].type == map[x1][y1].type &&
                            map[i][j].type == map[x2][y2].type &&
                            map[i][j].type == map[x3][y3].type){
                        map[i][j].flag = true;
                        map[x1][y1].flag = true;
                        map[x2][y2].flag = true;
                        map[x3][y3].flag = true;
                    }

                }catch (Exception ignored){}


            }
        }

    }

    public class Block{
        boolean flag;
        char type;

        public Block(){};
        public Block(boolean flag , char type){
            this.flag = flag;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {
                "CCBDE",
                "AAADE",
                "AAABF",
                "CCBBF"};
        int result = 14;

        Kakao_프렌즈4블록 temp = new Kakao_프렌즈4블록();

        int answer = temp.solution(m, n, board);
        System.out.println(answer);
    }
}
