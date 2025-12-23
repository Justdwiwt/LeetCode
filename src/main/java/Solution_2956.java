package main.java;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_2956 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        int cnt1 = (int) Arrays.stream(nums1).filter(set2::contains).count();
        int cnt2 = (int) Arrays.stream(nums2).filter(set1::contains).count();
        return new int[]{cnt1, cnt2};
    }
}
