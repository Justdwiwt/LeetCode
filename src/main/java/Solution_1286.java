package main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1286 {
    static class CombinationIterator {
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;

        public CombinationIterator(String characters, int combinationLength) {
            dfs(characters, combinationLength, 0);
        }

        void dfs(String characters, int combinationLength, int index) {
            if (sb.length() == combinationLength) list.add(sb.toString());
            IntStream.range(index, characters.length()).forEach(i -> {
                sb.append(characters.charAt(i));
                dfs(characters, combinationLength, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            });
        }

        public String next() {
            return list.get(index++);
        }

        public boolean hasNext() {
            return index < list.size();
        }
    }
}
