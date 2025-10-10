package main.java;

import java.util.List;

public class Solution_2856 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int maxCount = 1;
        int count = 0;
        int prev = 0;
        for (int num : nums)
            if (num == prev) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 1;
                prev = num;
            }
        int n = nums.size();
        return maxCount * 2 <= n ? n % 2 : maxCount * 2 - n;
    }
}
