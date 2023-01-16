package main.java;

import java.util.Arrays;

public class Solution_1320 {
    int[][][] dp;

    public int minimumDistance(String word) {
        dp = new int[300][27][27];
        Arrays.stream(dp).flatMap(Arrays::stream).forEach(anInt -> Arrays.fill(anInt, -1));
        return dfs(word, -1, -1, 0);
    }

    private int dfs(String word, int posa, int posb, int index) {
        int n = word.length();
        if (index >= n) return 0;
        if (dp[index][posa + 1][posb + 1] != -1) return dp[index][posa + 1][posb + 1];
        int pos = word.charAt(index) - 'A';
        int[] cur = getPostions(pos);
        int one = getOne(word, posa, posb, index, pos, cur);
        int two = getOne(word, posb, pos, index, posa, cur);
        int min = Math.min(one, two);
        dp[index][posa + 1][posb + 1] = min;
        return min;
    }

    private int getOne(String word, int posa, int posb, int index, int pos, int[] cur) {
        int one;
        if (posa == -1) one = dfs(word, pos, posb, index + 1);
        else {
            int[] postions = getPostions(posa);
            int dist = Math.abs(postions[0] - cur[0]) + Math.abs(postions[1] - cur[1]);
            one = dist + dfs(word, pos, posb, index + 1);
        }
        return one;
    }

    private int[] getPostions(int pos) {
        return new int[]{pos / 6, pos % 6};
    }
}
