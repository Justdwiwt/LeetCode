package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1079 {
    int res = 0;

    public int numTilePossibilities(String tiles) {
        char[] cs = tiles.toCharArray();
        Arrays.sort(cs);
        dfs(cs, new boolean[cs.length]);
        return res;
    }

    void dfs(char[] cs, boolean[] st) {
        IntStream.range(0, cs.length).filter(i -> !st[i]).filter(i -> i == 0 || cs[i] != cs[i - 1] || st[i - 1]).forEach(i -> {
            st[i] = true;
            res++;
            dfs(cs, st);
            st[i] = false;
        });
    }
}
