package main.java;

public class Solution_1330 {
    public int maxValueAfterReverse(int[] nums) {
        int val = 0;
        int maxBottom = Integer.MIN_VALUE;
        int minUpper = Integer.MAX_VALUE;
        int add = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            val += Math.abs(nums[i] - nums[i + 1]);
            maxBottom = Math.max(maxBottom, Math.min(nums[i], nums[i + 1]));
            minUpper = Math.min(minUpper, Math.max(nums[i], nums[i + 1]));
        }
        add = Math.max(add, 2 * (maxBottom - minUpper));
        for (int i = 1; i < n - 1; i++)
            add = Math.max(add, Math.abs(nums[i + 1] - nums[0]) - Math.abs(nums[i + 1] - nums[i]));
        for (int i = n - 2; i > 0; i--)
            add = Math.max(add, Math.abs(nums[i - 1] - nums[n - 1]) - Math.abs(nums[i - 1] - nums[i]));
        return val + add;
    }
}
