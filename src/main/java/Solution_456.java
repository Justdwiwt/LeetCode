package main.java;

import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution_456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] preMin = new int[n];
        preMin[0] = nums[0];
        IntStream.range(1, n).forEach(i -> preMin[i] = Math.min(preMin[i - 1], nums[i]));
        TreeSet<Integer> set = new TreeSet<>();
        set.add(nums[n - 1]);
        for (int i = n - 2; i >= 1; i--) {
            int lMin = preMin[i - 1];
            Integer higher = set.higher(lMin);
            if (higher != null && nums[i] > lMin && nums[i] > higher && lMin < higher) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
