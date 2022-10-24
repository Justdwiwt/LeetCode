package main.java;

public class Solution_1671 {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int[] increment = new int[n];
        for (int i = 0; i < n; ++i) {
            increment[i] = 1;
            for (int j = 0; j < i; ++j)
                if (nums[j] < nums[i])
                    increment[i] = Math.max(increment[i], increment[j] + 1);
        }
        int[] decrement = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            decrement[i] = 1;
            for (int j = i + 1; j < n; ++j)
                if (nums[j] < nums[i])
                    decrement[i] = Math.max(decrement[i], decrement[j] + 1);
            if (increment[i] > 1 && decrement[i] > 1)
                maxLen = Math.max(maxLen, increment[i] + decrement[i] - 1);
        }
        return n - maxLen;
    }
}
