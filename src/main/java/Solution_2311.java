package main.java;

public class Solution_2311 {
    public int longestSubsequence(String s, int k) {
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) == '0') cnt++;
            else if (k >= (1 << cnt) && cnt <= 30) {
                k -= (1 << cnt);
                cnt++;
            }
        return cnt;
    }
}
