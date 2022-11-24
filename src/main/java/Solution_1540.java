package main.java;

import java.util.stream.IntStream;

public class Solution_1540 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];
        IntStream.range(0, s.length()).forEach(i -> cnt[(26 + t.charAt(i) - s.charAt(i)) % 26]++);
        int res = 0;
        for (int i = 1; i < 26; i++) {
            if (cnt[i] == 0) continue;
            res = Math.max(res, i + 26 * (cnt[i] - 1));
        }
        return res <= k;
    }
}
