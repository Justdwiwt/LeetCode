package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        return dp(s, wordDict, memo);
    }

    public boolean dp(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if (s.isEmpty()) return true;
        if (memo.containsKey(s)) return memo.get(s);

        for (String word : wordDict) {
            if (word.length() > s.length()) continue;

            boolean qualified = s.startsWith(word);
            if (!qualified) continue;

            qualified = dp(s.substring(word.length()), wordDict, memo);
            if (qualified) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
