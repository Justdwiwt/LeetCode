package main.java;

import java.util.Arrays;

public class Solution_2967 {
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int m = nums[nums.length / 2], p = pl(m);
        long res = cost(nums, p);
        if (p < m)
            res = Math.min(res, cost(nums, nextLarger(p)));
        if (p > m)
            res = Math.min(res, cost(nums, nextSmaller(p)));
        return res;
    }

    public long cost(int[] nums, int p) {
        return Arrays.stream(nums).mapToLong(x -> Math.abs(x - p)).sum();
    }

    public int pl(int p) {
        char[] cs = String.valueOf(p).toCharArray();
        int lt = 0, rt = cs.length - 1;
        while (lt < rt)
            cs[rt--] = cs[lt++];
        return Integer.parseInt(new String(cs));
    }

    public int nextLarger(int p) {
        return pl(p + (int) Math.pow(10, String.valueOf(p).length() / 2));
    }

    public int nextSmaller(int p) {
        int pow = (int) Math.pow(10, String.valueOf(p).length() / 2);
        p = p / pow * pow - 1;
        return pl(p);
    }
}
