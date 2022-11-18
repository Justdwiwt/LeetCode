package main.java;

public class Solution_1567 {
    public int getMaxLen(int[] nums) {
        int pos = nums[0] > 0 ? 1 : 0;
        int neg = nums[0] < 0 ? 1 : 0;
        int res = pos;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos++;
                neg = neg == 0 ? 0 : neg + 1;
            } else if (nums[i] < 0) {
                int t = pos;
                pos = neg == 0 ? 0 : neg + 1;
                neg = t + 1;
            } else {
                pos = 0;
                neg = 0;
            }
            res = Math.max(pos, res);
        }
        return res;
    }
}
