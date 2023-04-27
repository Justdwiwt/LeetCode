package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        return IntStream.range(0, words.length)
                .filter(i -> isMatched(pattern.toCharArray(), words[i].toCharArray()))
                .mapToObj(i -> words[i])
                .collect(Collectors.toList());
    }

    private boolean isMatched(char[] c, char[] c1) {
        int[] map = new int[130];
        boolean[] hasMap = new boolean[130];
        Arrays.fill(map, -1);
        for (int i = 0; i < c.length; i++)
            if (map[c[i]] == -1) {
                if (hasMap[c1[i]]) return false;
                map[c[i]] = c1[i];
                hasMap[c1[i]] = true;
            } else if (map[c[i]] != c1[i]) return false;
        return true;
    }
}
