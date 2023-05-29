package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_791 {
    public String customSortString(String order, String s) {
        int[] map = new int[26];
        Arrays.fill(map, 100);
        IntStream.range(0, order.length()).forEach(i -> map[order.charAt(i) - 'a'] = i);
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) list.add(c);
        list.sort(Comparator.comparingInt(a -> map[a - 'a']));
        StringBuilder sb = new StringBuilder();
        for (char c : list) sb.append(c);
        return sb.toString();
    }
}
