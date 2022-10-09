package main.java;

import java.util.*;
import java.util.function.BiFunction;

public class Solution_1733 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> st = new HashSet<>();

        BiFunction<Integer, Integer, Boolean> check = (a, b) -> Arrays.stream(languages[a])
                .anyMatch(x -> Arrays.stream(languages[b]).anyMatch(y -> x == y));

        Arrays.stream(friendships).forEach(friendship -> {
            int u = friendship[0] - 1;
            int v = friendship[1] - 1;
            if (!check.apply(u, v)) {
                st.add(u);
                st.add(v);
            }
        });

        Map<Integer, Integer> language = new HashMap<>();

        int max = 0;
        for (int u : st)
            for (int x : languages[u]) {
                language.put(x, language.getOrDefault(x, 0) + 1);
                max = Math.max(language.get(x), max);
            }

        return st.size() - max;
    }
}
