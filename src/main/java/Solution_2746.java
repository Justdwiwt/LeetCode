package main.java;

import java.util.Arrays;

public class Solution_2746 {
    final int N = 1010;

    int n;
    String[] words;
    int[][][] memo = new int[N][26][26];

    public int minimizeConcatenatedLength(String[] words) {
        this.n = words.length;
        this.words = words;
        Arrays.stream(memo).forEach(ints -> Arrays.stream(ints).forEach(anInt -> Arrays.fill(anInt, -1)));
        return dfs(1, words[0].charAt(0) - 'a', words[0].charAt(words[0].length() - 1) - 'a') + words[0].length();
    }

    public int dfs(int u, int l, int r) {
        if (u == n) return 0;
        if (memo[u][l][r] != -1) return memo[u][l][r];
        int ans1 = dfs(u + 1, l, words[u].charAt(words[u].length() - 1) - 'a') + (words[u].length() - (words[u].charAt(0) - 'a' == r ? 1 : 0));
        int ans2 = dfs(u + 1, words[u].charAt(0) - 'a', r) + (words[u].length() - (words[u].charAt(words[u].length() - 1) - 'a' == l ? 1 : 0));
        memo[u][l][r] = Math.min(ans1, ans2);
        return memo[u][l][r];
    }
}
