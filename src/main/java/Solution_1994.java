package main.java;

public class Solution_1994 {
    final static int M = (int) 1e9 + 7;
    static int[] map = new int[31];

    static {
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int i = 2; i <= 30; ++i) {
            if (0 == i % 4 || 0 == i % 9 || 25 == i) continue;
            int mask = 0;
            for (int j = 0; j < 10; ++j)
                if (0 == i % prime[j]) mask |= 1 << j;
            map[i] = mask;
        }
    }

    public int numberOfGoodSubsets(int[] nums) {
        int one = 0;
        int[] dp = new int[1024], cnt = new int[31];
        dp[0] = 1;
        for (int i : nums)
            if (1 == i) one++;
            else if (0 != map[i]) cnt[i]++;
        for (int i = 0; i < 31; ++i) {
            if (0 == cnt[i]) continue;
            for (int j = 0; j < 1024; ++j) {
                if (0 != (j & map[i])) continue;
                dp[j | map[i]] = (int) ((dp[j | map[i]] + dp[j] * (long) cnt[i]) % M);
            }
        }
        long res = 0;
        for (int i : dp) res = (res + i) % M;
        res--;
        if (0 != one) res = res * pow(one) % M;
        return (int) res;
    }

    private long pow(int n) {
        long res = 1, m = 2;
        while (0 != n) {
            if (1 == (n & 1)) res = (res * m) % M;
            m = m * m % M;
            n >>= 1;
        }
        return res;
    }
}
