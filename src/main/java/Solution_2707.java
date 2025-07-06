package main.java;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_2707 {
    public int minExtraChar(String s, String[] words) {
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        int[] dp = new int[s.length() + 1];
        for (int end = 1; end <= s.length(); end++) {
            dp[end] = dp[end - 1] + 1;
            for (int begin = 0; begin < end; begin++) {
                if (set.contains(s.substring(begin, end))) {
                    dp[end] = Math.min(dp[end], dp[begin]);
                }
            }
        }
        return dp[s.length()];
    }
}
