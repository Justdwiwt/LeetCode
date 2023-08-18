package main.java;

public class Solution_1388 {
    public int maxSizeSlices(int[] nums) {
        int n = nums.length, m = n / 3;
        int[][] dp1 = new int[n + 1][m + 1];
        int[][] dp2 = new int[n + 1][m + 1];
        for (int i = 0; i < n - 1; ++i)
            for (int j = 1; j <= m; ++j) {
                dp1[i + 2][j] = Math.max(dp1[i + 1][j], dp1[i][j - 1] + nums[i]);
                dp2[i + 2][j] = Math.max(dp2[i + 1][j], dp2[i][j - 1] + nums[i + 1]);
            }
        return Math.max(dp1[n][m], dp2[n][m]);
    }
}
