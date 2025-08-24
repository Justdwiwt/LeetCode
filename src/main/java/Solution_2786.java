package main.java;

public class Solution_2786 {
    public long maxScore(int[] nums, int x) {
        long evenMax = Integer.MIN_VALUE;
        long oddMax = Integer.MIN_VALUE;
        if (nums[0] % 2 == 0) evenMax = nums[0];
        else oddMax = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] % 2 == 0) evenMax = Math.max(evenMax + nums[i], oddMax + nums[i] - x);
            else oddMax = Math.max(oddMax + nums[i], evenMax + nums[i] - x);
        return Math.max(evenMax, oddMax);
    }
}
