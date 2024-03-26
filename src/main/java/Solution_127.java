package main.java;

import java.util.*;

public class Solution_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        Map<String, Integer> visited = new HashMap<>();
        visited.put(beginWord, 1);
        Set<String> wordSet = new HashSet<>(wordList);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (int i = 0; i < cur.length(); i++)
                for (int j = 0; j < 26; j++) {
                    String newWord = cur.substring(0, i) + (char) ('a' + j) + cur.substring(i + 1);
                    if (wordSet.contains(newWord)) {
                        if (newWord.equals(endWord)) return visited.get(cur) + 1;
                        if (!visited.containsKey(newWord)) {
                            queue.offer(newWord);
                            visited.put(newWord, visited.get(cur) + 1);
                        }
                    }
                }
        }
        return 0;
    }
}
