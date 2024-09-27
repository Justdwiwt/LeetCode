package main.java;

import java.util.Arrays;

public class Solution_2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] arr = new int[101];
        int res = (int) Arrays.stream(nums).filter(num -> (arr[num] ^= 1) == 0).count();
        return new int[]{res, nums.length - 2 * res};
    }
}
