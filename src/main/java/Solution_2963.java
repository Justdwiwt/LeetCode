package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2963 {
    int mod = (int) 1e9 + 7;

    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;
        Map<Integer, int[]> map = new HashMap<>();
        IntStream.range(0, n).forEach(i -> {
            int[] a = map.getOrDefault(nums[i], new int[]{i, i});
            a[1] = i;
            map.put(nums[i], a);
        });
        List<int[]> intervals = new ArrayList<>(map.values());
        intervals.sort(Comparator.comparingInt(a -> a[0]));
        int l = 0, r = 1, size = intervals.size();
        while (r < size) {
            int[] a = intervals.get(l), b = intervals.get(r);
            if (b[0] < a[1])
                intervals.get(l)[1] = Math.max(a[1], b[1]);
            else {
                l++;
                intervals.set(l, b);
            }
            r++;
        }
        int ans = 1;
        for (int i = 0; i < l; i++)
            ans = ans * 2 % mod;
        return ans;
    }
}
