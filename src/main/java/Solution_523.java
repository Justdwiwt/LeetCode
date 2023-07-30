package main.java;

import java.util.HashSet;
import java.util.stream.IntStream;

public class Solution_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        IntStream.range(1, n + 1).forEach(i -> prefix[i] = nums[i - 1] + prefix[i - 1]);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(prefix[i - 2] % k);
            if (set.contains(prefix[i] % k)) return true;
        }
        return false;
    }
}
