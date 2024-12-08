package main.java;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution_2426 {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        Set<Integer> set = new TreeSet<>();
        IntStream.range(0, n).forEach(i -> {
            set.add(nums1[i] - nums2[i]);
            set.add(nums1[i] - nums2[i] + diff);
        });
        int m = set.size(), idx = 0;
        int[] nums = new int[m];
        for (int num : set)
            nums[idx++] = num;
        int[] tree = new int[m + 1];
        long res = 0;
        for (int i = 0; i < n; i++) {
            int num = nums1[i] - nums2[i];
            int x = Arrays.binarySearch(nums, num + diff), y = Arrays.binarySearch(nums, num);
            for (int j = x + 1; j > 0; j &= j - 1)
                res += tree[j];
            for (int j = y + 1; j <= m; j += j & -j)
                tree[j]++;
        }
        return res;
    }
}
