package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] idx = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingInt(a -> nums[a]));
        for (int i = 0, j = 1; i < n; j++) {
            List<Integer> index = new ArrayList<>();
            List<Integer> value = new ArrayList<>();
            while (j < n && limit >= nums[idx[j]] - nums[idx[j - 1]])
                j++;
            IntStream.range(i, j).forEach(k -> {
                index.add(idx[k]);
                value.add(nums[idx[k]]);
            });
            Collections.sort(index);
            for (int k = i; k < j; k++)
                nums[index.get(k - i)] = value.get(k - i);
            i = j;
        }
        return nums;
    }
}
