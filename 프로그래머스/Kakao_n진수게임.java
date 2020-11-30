package 프로그래머스;

public class Kakao_n진수게임 {
    static char[] c = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};        //16개의 숫자를 넣는다.

    public String solution(int n, int t, int m, int p) {
        String answer;

        int loop = t * m;
        StringBuilder sb = new StringBuilder();
        sb.append(0);

        for(int i=1; i<loop; i++){
            sb.append(nConversion(i, n));
        }

        StringBuilder result = new StringBuilder();
        int index = p-1;
        for(int i=0; i<t; i++){
            result.append(sb.charAt(index));
            index += m;
        }

        answer = result.toString();
        System.out.println(answer);
        return answer;
    }

    private String nConversion(int number, int n) {

        StringBuilder sb = new StringBuilder();
        while(number/n!=0)                //몫이 0이 될때까지
        {
            int a = number%n;
            sb.insert(0, c[a]);
            number = number/n;
        }

        sb.insert(0, c[number%n]);

        return sb.toString();
    }

    public static void main(String[] args) {
        Kakao_n진수게임 temp = new Kakao_n진수게임();
        temp.solution(16, 16, 2, 1);
    }
}
