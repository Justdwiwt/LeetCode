package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_893 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            char[] chars = s.toCharArray();
            List<Character> odd = new ArrayList<>();
            List<Character> even = new ArrayList<>();
            IntStream.range(0, chars.length).forEach(i -> {
                if (i % 2 != 0) odd.add(chars[i]);
                else even.add(chars[i]);
            });
            Collections.sort(odd);
            Collections.sort(even);
            StringBuilder builder = new StringBuilder();
            odd.forEach(builder::append);
            even.forEach(builder::append);
            set.add(builder.toString());
        }
        return set.size();
    }
}
