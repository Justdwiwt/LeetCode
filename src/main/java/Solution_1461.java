package main.java;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_1461 {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        IntStream.rangeClosed(0, n - k).mapToObj(i -> s.substring(i, i + k)).forEach(set::add);
        return set.size() == (1 << k);
    }
}
