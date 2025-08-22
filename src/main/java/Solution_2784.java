package main.java;

import java.util.Arrays;

public class Solution_2784 {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int maxNum = nums[nums.length - 1];
        int[] records = new int[maxNum + 1];
        Arrays.stream(nums).forEach(n -> ++records[n]);
        for (int i = 1; i < records.length - 1; ++i)
            if (1 != records[i]) return false;
        return 2 == records[maxNum];
    }
}
