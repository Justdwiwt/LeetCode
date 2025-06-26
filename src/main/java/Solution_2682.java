package main.java;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2682 {
    public int[] circularGameLosers(int n, int k) {
        Set<Integer> set = IntStream.range(1, n).boxed().collect(Collectors.toSet());
        int tmp = k;
        int times = 1;
        while (set.contains(tmp)) {
            set.remove(tmp);
            tmp = (tmp + ++times * k) % n;
        }
        return set.stream().mapToInt(Integer::intValue).map(num -> num + 1).toArray();
    }
}
