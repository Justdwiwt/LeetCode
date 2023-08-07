package main.java;

public class Solution_494 {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    private int dfs(int[] nums, int target, int idx, int sum) {
        return idx == nums.length ? sum == target ? 1 : 0 : dfs(nums, target, idx + 1, sum - nums[idx]) + dfs(nums, target, idx + 1, sum + nums[idx]);
    }
}
