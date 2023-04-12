package main.java;

public class Solution_935 {
    private final int[][] path = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {4, 2}};
    private static final int M = 1000000007;

    public int knightDialer(int N) {
        int[][] memo = new int[N][10];
        int res = 0;
        for (int num = 0; num < 10; num++)
            res = (res + helper(N - 1, num, memo, path)) % M;
        return res;
    }


    private int helper(int n, int num, int[][] memo, int[][] path) {
        if (n == 0) return 1;
        if (memo[n][num] != 0)
            return memo[n][num];
        int res = 0;
        for (int neighbor : path[num])
            res = (res + helper(n - 1, neighbor, memo, path)) % M;
        return memo[n][num] = res;
    }
}
