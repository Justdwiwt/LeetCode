package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2896 {
    public int minOperations(String s1, String s2, int x) {
        List<Integer> list = IntStream.range(0, s1.length()).filter(i -> s1.charAt(i) != s2.charAt(i)).boxed().collect(Collectors.toList());
        int n = list.size();
        if (n % 2 > 0)
            return -1;
        int[] t = new int[]{n / 2 * x, n / 2 * x};
        for (int i = 1; i < n; i++) {
            int[] tt = new int[2];
            tt[0] = Math.min(t[0], t[1]);
            tt[1] = t[0] - x + list.get(i) - list.get(i - 1);
            t = tt;
        }
        return Math.min(t[0], t[1]);
    }
}
