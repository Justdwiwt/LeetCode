package main.java;

import java.util.Collections;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Solution_2306 {
    public long distinctNames(String[] ideas) {
        HashSet<String> set = new HashSet<>();
        int[][] cnt = new int[26][26];
        Collections.addAll(set, ideas);
        for (String idea : ideas)
            IntStream.range(0, 26).forEach(j -> {
                char c = (char) ('a' + j);
                if (!set.contains(c + idea.substring(1))) cnt[idea.charAt(0) - 'a'][j]++;
            });
        long res = 0;
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++) res += (long) cnt[i][j] * cnt[j][i];
        return res;
    }
}
