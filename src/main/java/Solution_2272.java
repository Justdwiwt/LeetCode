package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2272 {
    public int largestVariance(String s) {
        int res = 0;
        int[][] diff = new int[26][26];
        int[][] diffWithB = new int[26][26];
        IntStream.range(0, 26).forEach(i -> Arrays.fill(diffWithB[i], -s.length()));
        for (int k = 0; k < s.length(); k++) {
            int ch = s.charAt(k) - 'a';
            for (int i = 0; i < 26; ++i) {
                if (i == ch) continue;
                ++diff[ch][i];
                ++diffWithB[ch][i];
                diffWithB[i][ch] = --diff[i][ch];
                diff[i][ch] = Math.max(diff[i][ch], 0);
                res = Math.max(res, Math.max(diffWithB[ch][i], diffWithB[i][ch]));
            }
        }
        return res;
    }
}
