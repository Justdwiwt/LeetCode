package main.java;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2514 {
    static int M = 1000000007;

    public int countAnagrams(String s) {
        long[] dp = new long[s.length() + 1];
        long p = 1L;
        dp[0] = 1L;
        int[] cnt = new int[26];
        IntStream.rangeClosed(1, s.length()).forEach(i -> dp[i] = dp[i - 1] * i % M);
        for (String t : s.split(" ")) {
            Arrays.fill(cnt, 0);
            for (int c : t.toCharArray()) cnt[c - 'a']++;
            p = p * dp[t.length()] % M;
            for (int i : cnt)
                p = p * BigInteger.valueOf(dp[i]).modInverse(BigInteger.valueOf(M)).intValue() % M;
        }
        return (int) p;
    }
}
