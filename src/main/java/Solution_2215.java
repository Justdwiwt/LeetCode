package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(find(nums1, nums2), find(nums2, nums1));
    }

    private List<Integer> find(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2)
                .boxed()
                .collect(Collectors.toSet());

        return Arrays.stream(nums1)
                .filter(num -> !set.contains(num))
                .boxed()
                .distinct()
                .collect(Collectors.toList());
    }
}
