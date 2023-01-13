package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1331 {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] res, tmp = new int[n];
        System.arraycopy(arr, 0, tmp, 0, n);
        Arrays.sort(tmp);
        Map<Integer, Integer> map = new HashMap<>();
        int id = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && tmp[i] > tmp[i - 1]) id++;
            map.put(tmp[i], id);
        }
        res = IntStream.range(0, n).map(i -> map.get(arr[i])).toArray();
        return res;
    }
}
