package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums1).forEach(i -> Arrays.stream(nums2).forEach(j -> map.put(i + j, map.getOrDefault(i + j, 0) + 1)));
        return Arrays.stream(nums3).map(i -> Arrays.stream(nums4).map(j -> map.getOrDefault(-i - j, 0)).sum()).sum();
    }
}
