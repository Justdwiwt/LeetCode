package main.java;

public class Solution_1827 {
    public int minOperations(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] <= nums[i - 1]) {
                cnt += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        return cnt;
    }
}
