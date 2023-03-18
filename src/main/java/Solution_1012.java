package main.java;

import java.util.stream.IntStream;

public class Solution_1012 {
    int[] num;
    Integer[][][][] memo;

    public int numDupDigitsAtMostN(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        num = IntStream.range(0, ch.length).map(i -> ch[i] - '0').toArray();
        memo = new Integer[num.length + 2][2][2][1 << 10];
        return n - dfs(0, true, false, 0);
    }

    private int dfs(int i, boolean isLimit, boolean isNum, int mask) {
        if (memo[i][isLimit ? 1 : 0][isNum ? 1 : 0][mask] != null) return memo[i][isLimit ? 1 : 0][isNum ? 1 : 0][mask];
        if (i == num.length) return isNum ? 1 : 0;
        int res = 0;
        if (!isNum) res += dfs(i + 1, false, false, mask);
        int begin = isNum ? 0 : 1;
        int end = isLimit ? num[i] : 9;
        res += IntStream.rangeClosed(begin, end).filter(j -> ((mask >> j) & 1) == 0).map(j -> dfs(i + 1, isLimit && j == num[i], true, mask | (1 << j))).sum();
        return memo[i][isLimit ? 1 : 0][isNum ? 1 : 0][mask] = res;
    }
}
