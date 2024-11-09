package main.java;

public class Solution_2395 {
    public boolean findSubarrays(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i - 1];
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] + nums[j - 1] == sum) return true;
        }
        return false;
    }
}
