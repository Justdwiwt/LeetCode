package main.java;

import java.util.Arrays;

public class Solution_2679 {
    public int matrixSum(int[][] nums) {
        int n = nums.length, m = nums[0].length;
        Arrays.stream(nums, 0, n).forEach(Arrays::sort);
        int res = 0, tmp = 0;
        for(int i = m - 1; i >= 0; i--){
            for (int[] num : nums) tmp = Math.max(tmp, num[i]);
            res += tmp;
            tmp = 0;
        }
        return res;
    }
}
