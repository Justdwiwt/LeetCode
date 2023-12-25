package main.java;

public class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre = 1, suf = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = pre;
            pre *= nums[i];
        }
        for (int j = n - 1; j >= 0; j--) {
            res[j] *= suf;
            suf *= nums[j];
        }
        return res;
    }
}
