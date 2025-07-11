package main.java;

import java.util.stream.IntStream;

public class Solution_2712 {
    public long minimumCost(String s) {
        int l = s.length();
        long ans = IntStream.range(0, l / 2).filter(i -> s.charAt(i) != s.charAt(i + 1)).mapToLong(i -> i + 1).sum();
        for (int i = l - 1; i > l / 2; i--)
            if (s.charAt(i) != s.charAt(i - 1)) ans += l - i;
        return ans;
    }
}
