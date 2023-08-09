package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_487 {
    public boolean predictTheWinner(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int len = nums.length;
        int[][] dp = new int[len][len];
        IntStream.range(0, len).forEach(i -> dp[i][i] = nums[i]);
        IntStream.range(1, len).forEach(j -> dp[j - 1][j] = Math.max(dp[j - 1][j - 1], dp[j][j]));
        for (int i = 2; i < len; i++)
            for (int row = 0; i + row < len; row++)
                dp[row][row + i] = Math.max(nums[row] + Math.min(dp[row + 1][i + row - 1], dp[row + 2][i + row]),
                        nums[i + row] + Math.min(dp[row][i + row - 2], dp[row + 1][i + row - 1]));
        return dp[0][len - 1] >= (sum - dp[0][len - 1]);
    }
}
