package main.java;

public class Solution_2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        int preLeft = -1, left = 0, maxLen = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                left = preLeft == -1 ? 0 : preLeft;
                preLeft = i;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
