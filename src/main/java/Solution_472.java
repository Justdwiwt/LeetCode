package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_472 {
    static class Solution {
        static class Node {
            boolean isEnd;
            Node[] next;

            public Node() {
                isEnd = false;
                next = new Node[26];
            }
        }

        public void insert(String s) {
            Node node = root;
            for (int i = 0; i < s.length(); ++i) {
                int index = s.charAt(i) - 'a';
                if (node.next[index] == null)
                    node.next[index] = new Node();
                node = node.next[index];
            }
            node.isEnd = true;
        }

        List<String> res;
        Node root = new Node();

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            res = new ArrayList<>();
            Arrays.sort(words, Comparator.comparingInt(String::length));
            Arrays.stream(words).filter(s -> s.length() != 0).forEach(s -> {
                if (dfs(s, 0, new boolean[s.length()])) res.add(s);
                else insert(s);
            });
            return res;
        }

        public boolean dfs(String s, int start, boolean[] isVisit) {
            if (start == s.length()) return true;
            Node node = root;
            for (int i = start; i < s.length(); ++i) {
                int index = s.charAt(i) - 'a';
                if (node.next[index] != null) {
                    node = node.next[index];
                    if (node.isEnd && dfs(s, i + 1, isVisit)) return true;
                } else return false;
            }
            return false;
        }
    }
}
