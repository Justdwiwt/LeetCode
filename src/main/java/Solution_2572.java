package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_2572 {
    Map<Integer, Integer> map = new HashMap<>();
    int M = (int) 1e9 + 7;

    public int squareFreeSubsets(int[] nums) {
        int[] arr = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        IntStream.range(0, 10).forEach(i -> map.put(arr[i], i));
        long[] count = new long[1 << 10];
        for (int num : nums) {
            int k = process(num);
            if (k == -1) continue;
            long[] next = new long[1 << 10];
            for (int i = 0; i < 1 << 10; i++) {
                next[i] += count[i];
                next[i] %= M;
                if ((i & k) == 0) {
                    next[i | k] += count[i];
                    next[i | k] %= M;
                }
            }
            next[k] += 1;
            count = next;
        }
        long res = 0;
        for (long k : count) {
            res += k;
            res %= M;
        }
        return (int) res;
    }

    public int process(int num) {
        int res = 0;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0 && map.containsKey(i)) res |= 1 << map.get(i);
            if (num % (i * i) == 0) return -1;
        }
        return res;
    }
}
