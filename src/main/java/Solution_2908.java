package main.java;

public class Solution_2908 {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] mins = new int[n];
        mins[n - 1] = nums[n - 1];
        for (int i = n - 2; i > 0; i--) mins[i] = Math.min(mins[i + 1], nums[i + 1]);
        int min = Integer.MAX_VALUE, m = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            min = Math.min(min, nums[i - 1]);
            if (nums[i] > Math.max(min, mins[i])) m = Math.min(m, min + nums[i] + mins[i]);
        }
        return m >= Integer.MAX_VALUE ? -1 : m;
    }
}
