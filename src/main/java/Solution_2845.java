package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_2845 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Integer[] a = nums.toArray(new Integer[]{});
        int n = a.length;
        IntStream.range(0, n).forEach(i -> a[i] = (a[i] % modulo == k) ? 1 : 0);
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int s = 0;
        for (Integer integer : a) {
            s += integer;
            int now = s % modulo;
            ans += map.getOrDefault((now - k + modulo) % modulo, 0);
            map.put(now, map.getOrDefault(now, 0) + 1);
        }
        return ans;
    }
}
