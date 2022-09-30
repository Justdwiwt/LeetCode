package main.java;

public class Solution_1770 {
    int[][] memo = new int[1005][1005];

    public int maximumScore(int[] nums, int[] multipliers) {
        return recur(nums, multipliers, 0, nums.length - 1, 0);
    }

    private int recur(int[] nums, int[] arr, int p1, int p2, int index) {
        if (index == arr.length) return 0;
        if (memo[p1][nums.length - p2] != 0) return memo[p1][nums.length - p2];
        return memo[p1][nums.length - p2] = Math.max(nums[p1] * arr[index] +
                recur(nums, arr, p1 + 1, p2, index + 1), nums[p2] * arr[index] +
                recur(nums, arr, p1, p2 - 1, index + 1));
    }
}
