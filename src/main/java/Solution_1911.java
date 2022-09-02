package main.java;

public class Solution_1911 {
    public long maxAlternatingSum(int[] nums) {
        long res = 0;
        int pre = 0;
        for (int num : nums) {
            if (num > pre) res += num - pre;
            pre = num;
        }
        return res;
    }
}
