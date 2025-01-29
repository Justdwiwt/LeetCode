package main.java;

import java.util.stream.IntStream;

public class Solution_2484 {
    public int countPalindromes(String s) {
        long[] pre = new long[10], suf = new long[10];
        long[][] prePre = new long[10][10], sufSuf = new long[10][10];
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = s.charAt(i) - '0';
            IntStream.range(0, 10).forEach(j -> sufSuf[num][j] += suf[j]);
            suf[num]++;
        }
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            suf[num]--;
            IntStream.range(0, 10).forEach(j -> sufSuf[num][j] -= suf[j]);
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 10; k++)
                    res += prePre[j][k] * sufSuf[j][k];
            IntStream.range(0, 10).forEach(j -> prePre[num][j] += pre[j]);
            pre[num]++;
        }
        return (int) (res % 1_000_000_007);
    }
}
