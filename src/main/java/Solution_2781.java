package main.java;

import java.util.HashSet;
import java.util.List;

public class Solution_2781 {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> set = new HashSet<>(forbidden);
        int ans = 0, n = word.length();
        for (int i = 0, j = 0; j < n; j++) {
            int k = j;
            while (k >= i && j - k + 1 <= 10) {
                if (set.contains(word.substring(k, j + 1))) {
                    i = k + 1;
                    break;
                }
                k--;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
