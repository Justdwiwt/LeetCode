package main.java;

import java.util.Arrays;

public class Solution_2407 {
    int[] mx;

    public int lengthOfLIS(int[] nums, int k) {
        int n = Arrays.stream(nums).max().getAsInt() + 1;
        this.mx = new int[n * 4];
        int res = 1;
        for (int num : nums) {
            int t = query_max(1, 1, n, Math.max(num - k + 1, 0), num) + 1;
            res = Math.max(res, t);
            add(1, 1, n, num + 1, t);
        }
        return res;
    }

    public void add(int o, int l, int r, int idx, int val) {
        if (l == r) {
            mx[o] = Math.max(val, this.mx[o]);
            return;
        }
        int m = (l + r) / 2;
        if (idx <= m)
            add(o * 2, l, m, idx, val);
        else
            add(o * 2 + 1, m + 1, r, idx, val);
        this.mx[o] = Math.max(this.mx[o * 2], this.mx[o * 2 + 1]);
    }

    public int query_max(int o, int l, int r, int L, int R) {
        if (l >= L && r <= R)
            return this.mx[o];
        int m = (l + r) / 2;
        int res = 0;
        if (m >= L)
            res = query_max(o * 2, l, m, L, R);
        if (m < R)
            res = Math.max(res, query_max(o * 2 + 1, m + 1, r, L, R));
        return res;
    }
}
