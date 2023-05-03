package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] arr = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(nums1);
        Arrays.sort(arr, (i1, i2) -> nums2[i2] - nums2[i1]);
        int[] res = new int[n];
        for (int left = 0, right = n - 1, i = 0; i < n; i++) {
            int idx = arr[i];
            res[idx] = nums1[right] > nums2[idx] ? nums1[right--] : nums1[left++];
        }
        return res;
    }
}
