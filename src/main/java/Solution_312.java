package main.java;

public class Solution_312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] pb = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < n - i; l++) {
                int r = l + i;
                for (int k = l; k <= r; k++) {
                    int m = nums[k] * (l - 1 < 0 ? 1 : nums[l - 1]) * (r + 1 >= nums.length ? 1 : nums[r + 1]);
                    m += (k - 1 < l ? 0 : pb[l][k - 1]) + (k + 1 > r ? 0 : pb[k + 1][r]);
                    pb[l][r] = Math.max(pb[l][r], m);
                }
            }
        }
        return pb[0][n - 1];
    }
}
