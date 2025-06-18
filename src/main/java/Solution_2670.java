package main.java;

public class Solution_2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        long f = 0;
        for (int i = n - 2; i >= 0; i--) {
            res[i] = res[i + 1];
            if ((f & (1L << (nums[i + 1] - 1))) == 0) {
                res[i]++;
                f |= (1L << (nums[i + 1] - 1));
            }
        }
        f = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if ((f & (1L << (nums[i] - 1))) == 0) {
                k++;
                f |= (1L << (nums[i] - 1));
            }
            res[i] = k - res[i];
        }
        return res;
    }
}
