package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_952 {
    static int[] root = new int[100001];
    static boolean[] prime = new boolean[100001];

    public int largestComponentSize(int[] nums) {
        IntStream.range(0, 100000).forEach(i -> {
            root[i] = i;
            prime[i] = true;
        });
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 2; i <= 100000; i++)
            if (prime[i]) for (int j = i * 2; j <= 100000; j += i) {
                prime[j] = false;
                if (set.contains(j)) root[find(j)] = find(i);
            }
        Map<Integer, Integer> rootCount = new HashMap<>();
        int largestSize = 1;
        for (int num : nums) {
            int rootCur = find(num);
            rootCount.put(rootCur, rootCount.getOrDefault(rootCur, 0) + 1);
            largestSize = Math.max(rootCount.get(rootCur), largestSize);
        }
        return largestSize;
    }

    private int find(int a) {
        return root[a] != a ? find(root[a]) : root[a];
    }
}
