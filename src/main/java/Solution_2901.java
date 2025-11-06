package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2901 {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[][] dp = new int[n][2];
        List<String> ret = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> {
            dp[i][0] = 1;
            dp[i][1] = -1;
        });
        int maxlen = 0, idx = -1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--)
                if (groups[i] != groups[j] && caldis(words[i], words[j]))
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = j;
                    }
            if (dp[i][0] > maxlen) {
                maxlen = dp[i][0];
                idx = i;
            }
        }
        if (idx == -1) {
            ret.add(words[0]);
            return ret;
        }
        while (idx != -1) {
            ret.add(words[idx]);
            idx = dp[idx][1];
        }
        Collections.reverse(ret);
        return ret;
    }

    public boolean caldis(String a, String b) {
        if (a.length() != b.length()) return false;
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt += 1;
            if (cnt > 1) return false;
        }
        return cnt != 0;
    }
}
