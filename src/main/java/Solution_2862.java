package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2862 {
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Long> map = new HashMap<>();
        List<Integer> prime = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n; i++)
            if (isPrime[i]) {
                prime.add(i);
                for (int j = i * 2; j <= n; j += i)
                    isPrime[j] = false;
            }
        IntStream.rangeClosed(1, n).forEach(i -> {
            int a = find(i, prime);
            map.put(a, map.getOrDefault(a, 0L) + nums.get(i - 1));
        });
        long ans = 0;
        for (long a : map.values()) ans = Math.max(ans, a);
        return ans;
    }

    int find(int a, List<Integer> prime) {
        for (int b : prime)
            while (a % (b * b) == 0) a /= b * b;
        return a;
    }
}
