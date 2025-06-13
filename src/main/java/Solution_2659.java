package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution_2659 {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Integer[] idx = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingInt(a -> nums[a]));
        long ans = 0;
        int count = 1, pre = 0;
        for (int i = 1; i < n; i++)
            if (idx[i] > idx[i - 1]) count++;
            else {
                ans += n - pre;
                pre = i;
                count = 1;
            }
        return ans + count;
    }
}
