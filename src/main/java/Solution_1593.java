package main.java;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_1593 {
    private int mx = 0;

    public int maxUniqueSplit(String s) {
        f(s, new HashSet<>(), 0, 0);
        return mx;
    }

    private void f(String s, Set<String> set, int j, int sum) {
        IntStream.rangeClosed(j + 1, s.length()).filter(i -> !set.contains(s.substring(j, i))).forEach(i -> {
            set.add(s.substring(j, i));
            f(s, set, i, sum + 1);
            set.remove(s.substring(j, i));
        });
        mx = Math.max(mx, sum);
    }
}
