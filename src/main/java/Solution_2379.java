package main.java;

import java.util.stream.IntStream;

public class Solution_2379 {
    public int minimumRecolors(String blocks, int k) {
        char[] chs = blocks.toCharArray();
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i <= chs.length - k; i++) {
            int tmp = (int) IntStream.range(i, i + k).filter(j -> chs[j] == 'W').count();
            cnt = Math.min(cnt, tmp);
        }
        return cnt;
    }
}
