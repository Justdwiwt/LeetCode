package main.java;

public class Solution_1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int N = str1.length(), M = str2.length();
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                dp[i + 1][j + 1] = str1.charAt(i) == str2.charAt(j) ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
        int len = N + M - dp[N][M];
        char[] res = new char[len];
        while (N > 0 && M > 0 && len > 0) {
            char cur;
            if (str1.charAt(N - 1) == str2.charAt(M - 1)) {
                cur = str1.charAt(N - 1);
                N--;
                M--;
            } else cur = dp[N - 1][M] > dp[N][M - 1] ? str1.charAt(--N) : str2.charAt(--M);
            res[--len] = cur;
        }
        while (N > 0) res[--len] = str1.charAt(--N);
        while (M > 0) res[--len] = str2.charAt(--M);
        return new String(res);
    }
}
