package main.java;

public class Solution_745 {
    static class Trie {
        int idx;
        Trie[] children;

        public Trie() {
            idx = -1;
            children = new Trie[27];
        }
    }

    static class WordFilter {
        Trie trie;

        public WordFilter(String[] words) {
            trie = new Trie();
            for (int i = 0; i < words.length; i++)
                for (int j = 0; j <= words[i].length(); j++) {
                    String s = words[i].substring(j) + (char) (26 + 'a') + words[i];
                    insert(trie, s, i);
                }
        }

        public int f(String pref, String suff) {
            String s = suff + (char) (26 + 'a') + pref;
            Trie t = trie;
            for (int i = 0; i < s.length(); i++) {
                int a = s.charAt(i) - 'a';
                if (t.children[a] == null) return -1;
                t = t.children[a];
            }
            return t.idx;
        }

        void insert(Trie t, String s, int p) {
            for (int i = 0; i < s.length(); i++) {
                int a = s.charAt(i) - 'a';
                if (t.children[a] == null) t.children[a] = new Trie();
                t.children[a].idx = p;
                t = t.children[a];
            }
        }
    }
}
