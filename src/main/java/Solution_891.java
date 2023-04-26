package main.java;

import java.util.Arrays;

public class Solution_891 {

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long res = 0, pow = 1;
        for (int i = 0; i < nums.length; i++) {
            int m = (int) 1e9 + 7;
            res = (res + pow * (nums[i] - nums[n - 1 - i] + m)) % m;
            pow = pow * 2 % m;
        }
        return (int) res;
    }
}
