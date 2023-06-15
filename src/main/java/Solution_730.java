package main.java;

import java.util.stream.IntStream;

public class Solution_730 {
    final int M = (int) 1e9 + 7;

    public int countPalindromicSubsequences(String s) {
        char[] ch = s.toCharArray();
        long[][] res = new long[ch.length][ch.length];
        IntStream.range(0, ch.length).forEach(i -> res[i][i] = 1);
        for (int d = 1; d < ch.length; d++)
            for (int i = 0; i < ch.length - d; i++) {
                if (ch[i] == ch[i + d]) {
                    int l = i + 1, r = i + d - 1;
                    while (ch[l] != ch[i]) l++;
                    while (ch[r] != ch[i]) r--;
                    if (l > r) res[i][i + d] = res[i][i + d] = res[i + 1][i + d - 1] * 2 + 2;
                    else
                        res[i][i + d] = l == r ? res[i + 1][i + d - 1] * 2 + 1 : res[i + 1][i + d - 1] * 2 - res[l + 1][r - 1] + M;
                } else res[i][i + d] = res[i][i + d - 1] + res[i + 1][i + d] - res[i + 1][i + d - 1] + M;
                res[i][i + d] %= M;
            }
        return (int) res[0][ch.length - 1];
    }
}
