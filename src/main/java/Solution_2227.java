package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2227 {
    static class TrieNode {
        TrieNode[] childs;
        boolean isWord;

        public TrieNode() {
            childs = new TrieNode[26];
            isWord = false;
        }
    }

    public static class Encrypter {
        Map<Character, String> keyToVal;
        Map<String, List<Integer>> valToKey;
        Set<String> dict;
        TrieNode root;
        char[] keys;

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            keyToVal = new HashMap<>();
            valToKey = new HashMap<>();
            dict = new HashSet<>();
            root = new TrieNode();
            this.keys = keys;
            IntStream.range(0, keys.length).forEach(i -> {
                keyToVal.put(keys[i], values[i]);
                valToKey.computeIfAbsent(values[i], x -> new ArrayList<>()).add(i);
            });

            for (String d : dictionary) {
                TrieNode cur = root;
                for (char ch : d.toCharArray()) {
                    if (cur.childs[ch - 'a'] == null)
                        cur.childs[ch - 'a'] = new TrieNode();
                    cur = cur.childs[ch - 'a'];
                }
                cur.isWord = true;
            }
        }

        public String encrypt(String word1) {
            StringBuilder res = new StringBuilder();
            for (char ch : word1.toCharArray())
                res.append(keyToVal.get(ch));
            return res.toString();
        }

        public int decrypt(String word2) {
            return decrypt(root, word2, 0);
        }

        public int decrypt(TrieNode root, String word2, int start) {
            if (start == word2.length())
                return root.isWord ? 1 : 0;

            String curKey = word2.substring(start, start + 2);
            List<Integer> idx = valToKey.get(curKey);
            int res = 0;
            if (idx != null)
                res = idx.stream()
                        .mapToInt(i -> i)
                        .filter(i -> root.childs[keys[i] - 'a'] != null)
                        .map(i -> decrypt(root.childs[keys[i] - 'a'], word2, start + 2))
                        .sum();
            return res;
        }
    }
}
