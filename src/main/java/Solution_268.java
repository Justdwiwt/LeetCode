package main.java;

public class Solution_268 {
    public int missingNumber(int[] nums) {
        int n = nums.length, ans = n * (n + 1) >> 1;
        for (int num : nums) ans -= num;
        return ans;
    }
}
