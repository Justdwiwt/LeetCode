package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2007 {
    public int[] findOriginalArray(int[] changed) {
        int i = 0, len = changed.length, totalCount = 0;
        if (len % 2 == 1) return new int[0];
        int[] res = new int[len / 2];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(changed);
        for (int j = len - 1; j >= 0; j--) {
            int n = changed[j], cnt = map.getOrDefault(2 * n, 0);
            if (cnt > 0) {
                map.put(2 * n, cnt - 1);
                totalCount--;
                res[i++] = n;
            } else {
                map.put(n, map.getOrDefault(n, 0) + 1);
                totalCount++;
            }
        }
        return totalCount != 0 ? new int[0] : res;
    }
}
