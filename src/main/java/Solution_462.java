package main.java;

import java.util.Arrays;

public class Solution_462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, res = 0;
        while (i < j) res += nums[j--] - nums[i++];
        return res;
    }
}
