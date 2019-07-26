import java.util.Scanner;

public class Solution7584 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result = 0;
		for (int t = 1; t <= T; t++) {
			double k = sc.nextInt() - 1;

			while (k > 0) {
				if (k % 4 == 0) {
					result = 0;
					break;
				} else {
					if (k % 2 == 0) {
						result = 1;
						break;
					} else {
						k = (k - 1) / 2;
						if (k == 1 || k==3) {
							result = 0;
							break;
						} else if (k == 2) {
							result = 1;
							break;

						}
					}
				}

				

			}
			System.out.format("#%d %d\n", t, result);
		}

	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static long K;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long end = pow();
        for(int i=0;i<T;i++) {
            K = Long.parseLong(br.readLine());
            System.out.println("#"+(i+1)+" "+find(1,end));
        }
    }
    public static int find(long start, long end) {
        long mid = (start+end)/2;
        int result = -1;
        while(true) {
            if(mid>K) {
                result = 0;
                end = mid - 1;
            }
            else if(mid<K) {
                result = 1;
                start = mid + 1;
            }
            else {
                return result;
            }
            mid = (start+end)/2;
        }
    }
    public static long pow() {
        long result = 1;
        for(int i=0;i<60;i++)
            result*=2;
        return result;
    }
}