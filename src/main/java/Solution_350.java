package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2)
                .boxed()
                .filter(num -> {
                    if (list1.contains(num)) {
                        list1.remove(num);
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        return list2.stream()
                .mapToInt(integer -> integer)
                .toArray();
    }
}
