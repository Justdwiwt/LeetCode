package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2416 {
    static class Trie {
        int cnt = 0;
        boolean isEnd;
        Trie[] next;

        public Trie() {
            next = new Trie[26];
        }
    }

    Trie treeNode = new Trie();

    public void insert(String s) {
        Trie cur = treeNode;
        for (char c : s.toCharArray()) {
            if (cur.next[c - 'a'] == null)
                cur.next[c - 'a'] = new Trie();
            cur.next[c - 'a'].cnt++;
            cur = cur.next[c - 'a'];
        }
        cur.isEnd = true;
    }

    public int search(String s) {
        Trie cur = treeNode;
        int res = 0;
        for (char c : s.toCharArray()) {
            res += cur.next[c - 'a'].cnt;
            cur = cur.next[c - 'a'];
        }
        return res;
    }

    public int[] sumPrefixScores(String[] words) {
        int len = words.length;
        int[] res = new int[len];
        Arrays.stream(words).forEach(this::insert);
        IntStream.range(0, len).forEach(i -> {
            int tmp = search(words[i]);
            res[i] = tmp;
        });
        return res;
    }
}
