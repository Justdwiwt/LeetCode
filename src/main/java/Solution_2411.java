package main.java;

import java.util.stream.IntStream;

public class Solution_2411 {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] count = new int[31];
        int r = n - 1;
        for (int l = n - 1; l >= 0; l--) {
            add(nums[l], count);
            while (r > l && canRemove(nums[r], count)) {
                remove(nums[r], count);
                r -= 1;
            }
            res[l] = r - l + 1;
        }
        return res;
    }

    private boolean canRemove(int num, int[] count) {
        return IntStream.range(0, 31).noneMatch(i -> count[i] == 1 && ((num >> i) & 1) == 1);
    }

    private void remove(int num, int[] count) {
        IntStream.range(0, 31).filter(i -> ((num >> i) & 1) == 1).forEach(i -> count[i] -= 1);
    }

    private void add(int num, int[] count) {
        IntStream.range(0, 31).filter(i -> ((num >> i) & 1) == 1).forEach(i -> count[i] += 1);
    }
}
