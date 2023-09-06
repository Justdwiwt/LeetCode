package main.java;

import java.util.Arrays;

public class Solution_594 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0, res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1)
                begin++;
            if (nums[end] - nums[begin] == 1)
                res = Math.max(res, end - begin + 1);
        }
        return res;
    }
}