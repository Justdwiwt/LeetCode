package main.java;

public class Solution_76 {
    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (int i = 0; i < t.length(); i++) cnt[t.charAt(i)]++;
        int l = 0, r = 0, ansL = 0, ansR = 0, ans = Integer.MAX_VALUE, cntT = t.length();
        while (r < s.length()) {
            if (cnt[s.charAt(r++)]-- > 0) cntT--;
            while (cntT == 0) {
                if (r - l < ans) {
                    ans = r - l;
                    ansL = l;
                    ansR = r;
                }
                if (cnt[s.charAt(l++)]++ == 0) cntT++;
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
    }
}
