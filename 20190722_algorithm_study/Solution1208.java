import java.util.Scanner;


public class Solution1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result;
        int maxx = 0,minn = 0;
        int maxindex = 0;
        int minindex= 0;
        for (int test_case = 1; test_case <= 10; test_case++) {
             
            int numDump = sc.nextInt();
            int[] matrix = new int[100];
            for (int i = 0; i < 100; i++)
                matrix[i] = sc.nextInt();
             
            for (int i = 0; i <= numDump; i++) {
                maxx = 0;
                minn = 101;
                for (int a = 0; a < 100; a++) {
                    if (matrix[a] > maxx) {
                        maxx = matrix[a];
                        maxindex = a;
                    }
                    if (matrix[a] < minn) {
                        minn = matrix[a];
                        minindex = a;
                    }
                }
                matrix[maxindex]--;
                matrix[minindex]++;
            }
            result = maxx - minn;
            System.out.printf("#%d %d\n",test_case,result);
        }
    }
}