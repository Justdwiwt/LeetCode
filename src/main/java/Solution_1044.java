package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1044 {
    public String longestDupSubstring(String s) {
        String res = "";
        final int N = s.length();
        int lo = 0, hi = N - 1;
        long off = 31L;
        long[] hash = new long[N + 2], offset = new long[N + 2];
        offset[0] = 1L;
        IntStream.rangeClosed(1, N).forEach(i -> {
            hash[i] = hash[i - 1] * off + s.charAt(i - 1) - 'a' + 1;
            offset[i] = offset[i - 1] * off;
        });
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            Map<Long, Integer> map = new HashMap<>();
            boolean flag = false;
            for (int i = 0; i <= s.length() - mid; i++) {
                int end = i + mid;
                long val = hash[end] - hash[i] * offset[mid];
                int cnt = map.getOrDefault(val, 0);
                if (cnt > 0) {
                    flag = true;
                    res = s.substring(i, end);
                    break;
                }
                map.put(val, cnt + 1);
            }
            if (flag) lo = mid + 1;
            else hi = mid - 1;
        }
        return res;
    }
}
