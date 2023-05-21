package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_816 {
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length();
        s = s.substring(1, n - 1);
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n - 2; i++) {
            List<String> part1 = findSplit(s.substring(0, i)), part2 = findSplit(s.substring(i));
            part1.forEach(a -> part2.stream().map(b -> "(" + a + ", " + b + ")").forEach(res::add));
        }
        return res;
    }

    private List<String> findSplit(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() == 1 || s.charAt(0) != '0') list.add(s);
        IntStream.range(1, s.length()).forEach(i -> {
            String s1 = s.substring(0, i), s2 = s.substring(i);
            if ((s1.length() == 1 || s.charAt(0) != '0') && s2.charAt(s2.length() - 1) != '0') list.add(s1 + "." + s2);
        });
        return list;
    }
}
