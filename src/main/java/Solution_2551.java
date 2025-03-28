package main.java;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2551 {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (n == k) return 0;
        List<Long> list = IntStream.range(0, n - 1).mapToObj(i -> (long) (weights[i] + weights[i + 1])).collect(Collectors.toList());
        long ans = 0L;
        Collections.sort(list);
        for (int i = 0; i < k - 1; i++) ans -= list.get(i);
        for (int i = list.size() - 1, j = 0; j < k - 1; i--, j++) ans += list.get(i);
        return ans;
    }
}
