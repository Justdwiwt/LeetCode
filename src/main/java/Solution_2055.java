package main.java;

import java.util.stream.IntStream;

public class Solution_2055 {
    public int[] platesBetweenCandles(String s, int[][] qs) {
        char[] ch = s.toCharArray();
        int n = ch.length, m = qs.length;
        int[] l = new int[n], r = new int[n];
        int[] sum = new int[n + 1];
        for (int i = 0, j = n - 1, p = -1, q = -1; i < n; i++, j--) {
            if (ch[i] == '|') p = i;
            if (ch[j] == '|') q = j;
            l[i] = p;
            r[j] = q;
            sum[i + 1] = sum[i] + (ch[i] == '*' ? 1 : 0);
        }
        int[] res = new int[m];
        IntStream.range(0, m).forEach(i -> {
            int a = qs[i][0], b = qs[i][1];
            int c = r[a], d = l[b];
            if (c != -1 && c <= d) res[i] = sum[d + 1] - sum[c];
        });
        return res;
    }
}
