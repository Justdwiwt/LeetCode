package main.java;

public class Solution_2764 {
    public int alternatingSubarray(int[] nums) {
        int ans = -1;
        int length = -1;
        for (int i = 1; i < nums.length; i++) {
            if (length > 0 && nums[i] == nums[i - 2]) {
                length++;
            } else if (nums[i] - nums[i - 1] == 1) {
                length = 2;
            } else {
                length = -1;
            }
            ans = Math.max(ans, length);
        }
        return ans;
    }
}
