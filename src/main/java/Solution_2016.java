package main.java;

public class Solution_2016 {
    public int maximumDifference(int[] nums) {
        int mn = Integer.MAX_VALUE;
        int res = -1;
        for (int num : nums)
            if (num <= mn) mn = num;
            else res = Math.max(res, num - mn);
        return res;
    }
}
