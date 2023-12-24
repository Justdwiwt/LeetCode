package main.java;

public class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] q = new int[n];
        int hh = 0, tt = -1;
        int[] res = new int[n - (k - 1)];
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - (k - 1) > q[hh]) hh++;
            while (hh <= tt && nums[q[tt]] <= nums[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) res[i - (k - 1)] = nums[q[hh]];
        }
        return res;
    }
}
