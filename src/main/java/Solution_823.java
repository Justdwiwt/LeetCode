package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_823 {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int M = (int) 1e9 + 7, n = arr.length;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = arr[i];
            long cnt = 1L;
            cnt += Arrays.stream(arr, 0, i).filter(cl -> root % cl == 0 && map.containsKey(root / cl)).mapToLong(cl -> map.get(cl) * map.get(root / cl)).sum();
            map.put(root, cnt % M);

        }
        long res = 0;
        for (Long val : map.values()) res = (res + val) % M;
        return (int) (res % M);
    }
}
