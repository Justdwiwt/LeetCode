package main.java;

public class Solution_2555 {
    public int maximizeWin(int[] prizePositions, int k) {
        int len = prizePositions.length, l = 0, r = 0, max = 0;
        int[] dp = new int[len + 1];
        while (r < len)
            if (prizePositions[r] - prizePositions[l] <= k) {
                max = Math.max(max, r - l + 1 + dp[l]);
                dp[r + 1] = Math.max(dp[r], r - l + 1);
                r++;
            } else l++;
        return max;
    }
}
