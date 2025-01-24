package main.java;

public class Solution_2478 {
    private boolean isPrime(char c) {
        int num = c - '0';
        return num == 2 || num == 3 || num == 5 || num == 7;
    }

    public int beautifulPartitions(String s, int k, int minLength) {
        final int M = (int) 1e9 + 7;
        int n = s.length();
        if (isPrime(s.charAt(n - 1)) || !isPrime(s.charAt(0))) return 0;
        char[] chars = s.toCharArray();
        long[][] dp = new long[k + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            long now = 0;
            for (int j = minLength; j <= n; j++) {
                if (isPrime(chars[j - minLength])) now = (now + dp[i - 1][j - minLength]) % M;
                if (!isPrime(chars[j - 1])) dp[i][j] = now;
            }
        }

        return (int) dp[k][n];
    }
}
