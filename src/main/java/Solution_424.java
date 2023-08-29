package main.java;

public class Solution_424 {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int distanceMaxLen = 0;
        int left = 0, right = 0, len = s.length();
        while (right < len) {
            char ch = s.charAt(right);
            map[ch - 'A']++;
            distanceMaxLen = Math.max(distanceMaxLen, map[ch - 'A']);
            if (right - left + 1 - distanceMaxLen > k) {
                map[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
