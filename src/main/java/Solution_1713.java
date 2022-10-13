package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1713 {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = IntStream.range(0, target.length)
                .boxed()
                .collect(Collectors.toMap(i -> target[i], i -> i, (a, b) -> b));
        List<Integer> list = IntStream.range(0, arr.length)
                .filter(i -> map.containsKey(arr[i]))
                .mapToObj(i -> map.get(arr[i]))
                .collect(Collectors.toCollection(() -> new ArrayList<>(arr.length)));
        int res = 0;
        int[] dp = new int[list.size()];
        for (int num : list) {
            int start = 0;
            int end = res;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (dp[mid] < num) start = mid + 1;
                else end = mid;
            }
            dp[start] = num;
            if (start == res) res++;
        }
        return target.length - res;
    }
}
