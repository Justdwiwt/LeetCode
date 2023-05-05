package main.java;

import java.util.stream.IntStream;

public class Solution_861 {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[] arr = new boolean[m];
        IntStream.range(0, m).forEach(i -> arr[i] = A[i][0] == 0);
        int res = m << n - 1;
        for (int i = 1, cnt = 0; i < n; i++, cnt = 0) {
            for (int j = 0; j < m; j++) if (arr[j] ^ (A[j][i] == 0)) cnt++;
            cnt = Math.max(cnt, m - cnt);
            res += cnt << (n - i - 1);
        }
        return res;
    }
}
