package main.java;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution_2035 {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int sum = Arrays.stream(nums).sum();
        int[] A = new int[n], B = new int[n];
        TreeMap<Integer, TreeSet<Integer>> X = new TreeMap<>(), Y = new TreeMap<>();

        IntStream.range(0, n).forEach(i -> {
            A[i] = nums[i];
            B[i] = nums[i + n];
        });

        for (int mask = 0; mask < 1 << n; mask++) {
            int cnt_a = 0, cnt_b = 0;
            int cnt = Integer.bitCount(mask);
            for (int i = 0; i < n; i++)
                if (((mask >> i) & 1) == 1) {
                    cnt_a += A[i];
                    cnt_b += B[i];
                }
            TreeSet<Integer> set_a = X.getOrDefault(cnt, new TreeSet<>());
            TreeSet<Integer> set_b = Y.getOrDefault(cnt, new TreeSet<>());
            set_a.add(cnt_a);
            set_b.add(cnt_b);
            X.put(cnt, set_a);
            Y.put(cnt, set_b);
        }

        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, TreeSet<Integer>> en : X.entrySet()) {
            int bit_cnt = en.getKey();
            TreeSet<Integer> set_a = en.getValue();
            TreeSet<Integer> set_b = Y.get(n - bit_cnt);
            for (int i : set_a)
                if (set_b.floor(sum / 2 - i) != null) {
                    int j = set_b.floor((sum >> 1) - i);
                    res = Math.min(res, Math.abs((sum - i - j) - (i + j)));
                }
        }
        return res;
    }
}
