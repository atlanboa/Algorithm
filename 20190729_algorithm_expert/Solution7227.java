//import java.util.Scanner;
//
//class Point{
//	int x;
//	int y;
//}
//public class Solution7227 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		int N;
//		Point[] p;
//		for(int t=1; t<=T; t++) {
//			N = sc.nextInt();
//			p = new Point[N];
//			for(int i=0; i<p.length;i++) {
//				p[i].x = sc.nextInt();
//				p[i].y = sc.nextInt();		
//			}
//		}
//	}
//
//}


import java.util.Scanner;

public class Solution7227 {
    static long MAX =Long.MAX_VALUE;
    static int T = 0;
    int pos_x = 0;
    int pos_y = 0;
    static int count = 0;
    static int X = 0, Y = 0;
    static int[][] pos = new int[2][20];
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
 
        T = Integer.parseInt(sc.nextLine());
         
        for (int i = 0; i < T; i++) {
            X=0;
            Y=0;
            count = sc.nextInt();
 
            for (int j = 0; j < count; j++) {
                pos[0][j] = sc.nextInt();
                pos[1][j] = sc.nextInt();
                X -= pos[0][j];
                Y -= pos[1][j];
            } 
            System.out.println("#"+(i+1) +" " + com(0,0,X,Y));
        } 
    }
     
    private static long com(int a_num, int s, int x, int y){
    	System.out.format("a_num = %d , s = %d , x = %d, y = %d\n",a_num, s, x, y);
        if(a_num == count/2)
            return Math.min(MAX, (long)x*x + (long)y*y);
        long max = MAX;
        for(int n = s; n < count/2+a_num ; n++){
        	System.out.println(max);
            max = Math.min(max, com(a_num+1, n+1, x+2*(pos[0][n]), y+2*(pos[1][n])));
        }
        return max;
  
    }
     
     
}