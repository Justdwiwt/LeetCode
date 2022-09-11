package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1865 {
    static class FindSumPairs {
        Map<Integer, Integer> mapCount;
        int[] num1;
        int[] num2;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.num1 = nums1;
            this.num2 = nums2;
            mapCount = new HashMap<>();
            IntStream.range(0, nums2.length).forEach(i -> mapCount.put(nums2[i], mapCount.getOrDefault(nums2[i], 0) + 1));
        }

        public void add(int index, int val) {
            int n = num2[index];
            mapCount.put(n, mapCount.get(n) - 1);
            num2[index] += val;
            mapCount.put(num2[index], mapCount.getOrDefault(num2[index], 0) + 1);
        }

        public int count(int tot) {
            return Arrays.stream(num1)
                    .map(j -> mapCount.getOrDefault(tot - j, 0))
                    .sum();
        }
    }
}
