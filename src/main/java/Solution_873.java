package main.java;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = IntStream.range(0, n).boxed().collect(Collectors.toMap(i -> arr[i], i -> i, (a, b) -> b));
        int maxCnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int f1 = i;
                int f2 = j;
                int cnt = 2;
                while (f2 < n && indexMap.containsKey(arr[f1] + arr[f2])) {
                    int temp = f2;
                    f2 = indexMap.get(arr[f1] + arr[f2]);
                    f1 = temp;
                    cnt++;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }
        return maxCnt == 2 ? 0 : maxCnt;
    }
}
