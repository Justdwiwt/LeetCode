package main.java;

import java.util.stream.IntStream;

public class Solution_1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        int idx = 0;
        for (int i = 0; i < s.length(); i++)
            if (dp[i]) {
                int min = Math.min(i + maxJump, s.length() - 1);
                IntStream.rangeClosed(Math.max(idx, i + minJump), min).filter(j -> s.charAt(j) == '0').forEach(j -> dp[j] = true);
                idx = min;
            }
        return dp[dp.length - 1];
    }
}
