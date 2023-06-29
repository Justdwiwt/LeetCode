package main.java;

public class Solution_677 {
    static class MapSum {
        class TrieNode {
            TrieNode[] child = new TrieNode[26];
            int val = 0;
            int sum = 0;
        }

        TrieNode root = new TrieNode();

        public MapSum() {

        }

        public int search(String key) {
            TrieNode p = root;
            for (int i = 0; i < key.length(); i++) {
                int cur = key.charAt(i) - 'a';
                if (p.child[cur] == null) return 0;
                p = p.child[cur];
            }
            return p.val;
        }

        public void insert(String key, int val) {
            TrieNode p = root;
            int s = val - search(key);
            for (int i = 0; i < key.length(); i++) {
                int cur = key.charAt(i) - 'a';
                if (p.child[cur] == null) p.child[cur] = new TrieNode();
                p = p.child[cur];
                p.sum += s;
            }
            p.val = val;
        }

        public int sum(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                int cur = prefix.charAt(i) - 'a';
                if (p.child[cur] == null) return 0;
                p = p.child[cur];
            }
            return p.sum;
        }
    }
}
