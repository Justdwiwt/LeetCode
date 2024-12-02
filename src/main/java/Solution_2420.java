package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2420 {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        pref[0] = 1;
        suff[suff.length - 1] = 1;
        IntStream.range(1, nums.length).forEach(i -> {
            if (nums[i - 1] >= nums[i]) pref[i] = pref[i - 1] + 1;
            else pref[i] = 1;
        });
        for (int i = nums.length - 2; i >= 0; i--)
            if (nums[i] <= nums[i + 1]) suff[i] = suff[i + 1] + 1;
            else suff[i] = 1;
        return IntStream.range(1, nums.length - 1).filter(i -> pref[i - 1] >= k && suff[i + 1] >= k).boxed().collect(Collectors.toList());
    }
}
