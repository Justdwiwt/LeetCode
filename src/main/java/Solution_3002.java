package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_3002 {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = new HashSet<>();
        int common = 0;
        for (int x : nums2) {
            if (set2.contains(x)) continue;
            set2.add(x);
            if (set1.contains(x)) common++;
        }
        int n = nums1.length;
        int c1 = Math.min(set1.size() - common, n / 2);
        int c2 = Math.min(set2.size() - common, n / 2);
        return Math.min(n, c1 + c2 + common);
    }
}
