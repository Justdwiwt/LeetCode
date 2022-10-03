package main.java;

public class Solution_1758 {
    public int minOperations(String s) {
        int dp0 = 0, dp1 = 0;
        for (char ch : s.toCharArray()) {
            int zer0 = dp1 + (ch == '0' ? 0 : 1);
            int one = dp0 + (ch == '1' ? 0 : 1);
            dp0 = zer0;
            dp1 = one;
        }
        return Math.min(dp0, dp1);
    }
}
