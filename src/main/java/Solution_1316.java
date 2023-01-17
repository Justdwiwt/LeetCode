package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_1316 {
    public int distinctEchoSubstrings(String text) {
        Set<String> set = new HashSet<>();
        final int N = text.length();
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j - i <= N - j; j++) {
                String key = text.substring(i, j);
                if (text.startsWith(key, j)) set.add(key);
            }
        return set.size();
    }
}
