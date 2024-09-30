package main.java;

import java.util.Arrays;

public class Solution_2344 {
    public int minOperations(int[] nums, int[] numsDivide) {
        int p = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++)
            p = gcd(p, numsDivide[i]);
        Arrays.sort(nums);
        int ans = -1;
        for (int i = 0; i < nums.length; i++)
            if (p % nums[i] == 0) {
                ans = i;
                break;
            }
        return ans;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
