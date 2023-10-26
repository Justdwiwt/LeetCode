package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] flag = new boolean[1001];
        IntStream.range(0, nums1.length).forEach(i -> flag[nums1[i]] = true);
        int[] res = new int[nums1.length];
        int count = 0;
        for (int j : nums2)
            if (flag[j]) {
                flag[j] = false;
                res[count++] = j;
            }
        return Arrays.copyOf(res, count);
    }
}
