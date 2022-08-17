package main.java;

import java.util.Arrays;

public class Solution_1985 {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
        return nums[nums.length - k];
    }
}
