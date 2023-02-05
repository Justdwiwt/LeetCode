package main.java;

public class Solution_1234 {
    public int balancedString(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'A']++;
        int res = Integer.MAX_VALUE, j = 0, d = s.length() / 4;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']--;
            if (cnt['Q' - 'A'] <= d && cnt['W' - 'A'] <= d && cnt['E' - 'A'] <= d && cnt['R' - 'A'] <= d) {
                while (j <= i && cnt[s.charAt(j) - 'A'] < d) cnt[s.charAt(j++) - 'A']++;
                res = Math.min(res, i - j + 1);
            }
        }
        return res;
    }
}
