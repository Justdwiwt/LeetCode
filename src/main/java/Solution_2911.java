package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2911 {
    public int minimumChanges(String S, int k) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[][] modify = new int[n - 1][n];
        for (int left = 0; left < n - 1; left++)
            for (int right = left + 1; right < n; right++)
                modify[left][right] = getModify(s, left, right - left + 1);

        int[] f = modify[0];
        for (int i = 1; i < k; i++)
            for (int j = n - 1 - (k - 1 - i) * 2; j > i * 2; j--) {
                f[j] = Integer.MAX_VALUE;
                for (int L = i * 2; L < j; L++)
                    f[j] = Math.min(f[j], f[L - 1] + modify[L][j]);
            }
        return f[n - 1];
    }

    private static final int MX = 201;
    private static final List<Integer>[] divisors = new ArrayList[MX];

    static {
        Arrays.setAll(divisors, k -> new ArrayList<>());
        for (int i = 1; i < MX; i++)
            for (int j = i * 2; j < MX; j += i)
                divisors[j].add(i);
    }

    private int getModify(char[] s, int begin, int n) {
        int res = n;
        for (int d : divisors[n]) {
            int cnt = 0;
            for (int i0 = 0; i0 < d; i0++)
                for (int i = i0, j = n - d + i0; i < j; i += d, j -= d)
                    if (s[begin + i] != s[begin + j]) cnt++;
            res = Math.min(res, cnt);
        }
        return res;
    }
}
