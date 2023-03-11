package main.java;

import java.util.Arrays;

public class Solution_1032 {
    static class StreamChecker {
        Node root = new Node();

        static class Node {
            Node[] child = new Node[26];
            boolean isLetter;
        }

        void insert(String s) {
            Node cur = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (cur.child[c - 'a'] == null) cur.child[c - 'a'] = new Node();
                cur = cur.child[c - 'a'];
            }
            cur.isLetter = true;
        }

        public StreamChecker(String[] words) {
            Arrays.stream(words).forEach(this::insert);
        }

        StringBuilder sb = new StringBuilder();

        public boolean query(char letter) {
            sb.append(letter);
            Node cur = root;
            for (int i = sb.length() - 1; i >= 0; i--) {
                char c = sb.charAt(i);
                if (cur.child[c - 'a'] == null) return false;
                cur = cur.child[c - 'a'];
                if (cur.isLetter) return true;
            }
            return false;
        }
    }
}
