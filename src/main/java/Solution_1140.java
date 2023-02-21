package main.java;

public class Solution_1140 {
    public int stoneGameII(int[] piles) {
        int[][] dp = new int[piles.length + 1][f(piles.length) + 1];
        for (int a = piles.length - 2; a >= 0; a--)
            piles[a] += piles[a + 1];
        for (int a = piles.length - 1; a >= 0; a--)
            for (int b = 1; b <= f(a); b++)
                if (a + b * 2 >= piles.length) dp[a][b] = piles[a];
                else for (int c = 1; c <= b * 2; c++)
                    dp[a][b] = Math.max(dp[a][b], piles[a] - dp[a + c][Math.max(b, c)]);
        return dp[0][1];
    }

    private int f(int a) {
        double b = Math.log10(a + 1);
        double c = Math.log10(2);
        return (int) Math.pow(2, Math.ceil(b / c));
    }
}
