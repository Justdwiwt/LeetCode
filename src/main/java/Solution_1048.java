package main.java;

import java.util.Arrays;

public class Solution_1048 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() > o2.length()) return 1;
            else if (o1.length() < o2.length()) return -1;
            else return o1.compareTo(o2);
        });
        int res = 0;
        int[] dp = new int[words.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--)
                if (isSub(words[j - 1], words[i - 1]))
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private boolean isSub(String s1, String target) {
        if (target.length() - s1.length() != 1) return false;
        int sum = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == s1.charAt(sum)) sum++;
            if (sum == s1.length()) break;
        }
        return sum == s1.length();
    }
}
