package main.java;

import java.util.Arrays;

public class Solution_26 {
    public int removeDuplicates(int[] nums) {
        int[] distinctNums = Arrays.stream(nums)
                .distinct()
                .toArray();
        System.arraycopy(distinctNums, 0, nums, 0, distinctNums.length);
        return distinctNums.length;
    }
}
