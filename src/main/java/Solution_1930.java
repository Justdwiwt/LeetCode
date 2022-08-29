package main.java;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1930 {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> m = IntStream.range(0, s.length()).boxed().collect(Collectors.toMap(s::charAt, i -> i, (a, b) -> b));
        Set<String> res = new HashSet<>(), curr = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (curr.contains(String.valueOf(s.charAt(i))) && m.get(s.charAt(i)) == i)
                curr.remove(String.valueOf(s.charAt(i)));
            for (String c : curr) res.add(c + s.charAt(i) + c);
            if (m.get(s.charAt(i)) != i) curr.add(String.valueOf(s.charAt(i)));
        }
        return res.size();
    }
}
