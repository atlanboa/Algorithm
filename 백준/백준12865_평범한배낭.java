package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준12865_평범한배낭 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException{
        int n, k;
        int weight, value;
        int[][] backpack;
        ArrayList<Stuff> stuffs = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        backpack = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            stuffs.add(new Stuff(weight, value));
        }
        Collections.sort(stuffs);

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= k; j++)
            {
                Stuff t = stuffs.get(i - 1);
                if (t.weight > j)
                {
                    backpack[i][j] = backpack[i - 1][j];
                }
                else
                {
                    backpack[i][j] = Math.max(backpack[i - 1][j], t.value + backpack[i - 1][j - t.weight]);
                }
            }
        }
        System.out.println(backpack[n][k]);
    }

    public static class Stuff implements Comparable<Stuff>{
        int weight;
        int value;

        public Stuff(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Stuff o) {
            int cmp = Integer.compare(weight, o.weight);
            if (cmp == 0)
                return (Integer.compare(value, o.value));
            else
                return (cmp);
        }
    }
}
