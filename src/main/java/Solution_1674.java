package main.java;

public class Solution_1674 {
    public int minMoves(int[] nums, int limit) {
        int[] tmp = new int[2 * limit + 2];
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - i - 1]);
            int b = Math.max(nums[i], nums[n - i - 1]);
            tmp[a + 1]--;
            tmp[a + b]--;
            tmp[a + b + 1]++;
            tmp[limit + b + 1]++;
        }
        int cur = (n / 2) * 2;
        int res = n;
        for (int i = 2; i <= limit * 2; i++) {
            cur += tmp[i];
            res = Math.min(res, cur);
        }
        return res;
    }
}
