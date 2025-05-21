package main.java;

public class Solution_2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length(), cnt0 = 0, cnt1 = 0, maxL = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') cnt0++;
            else cnt1++;
            if (cnt0 >= cnt1) maxL = Math.max(maxL, cnt1 * 2);
            if (s.charAt(i) == '1' && i != n - 1 && s.charAt(i + 1) == '0') {
                cnt0 = 0;
                cnt1 = 0;
            }
        }
        return maxL;
    }
}
