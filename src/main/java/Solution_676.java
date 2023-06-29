package main.java;

import java.util.stream.IntStream;

public class Solution_676 {
    static class MagicDictionary {

        private String[] dictionary;

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            this.dictionary = dictionary;
        }

        public boolean search(String searchWord) {
            char[] c = searchWord.toCharArray();
            for (String word : dictionary)
                if (searchWord.length() != word.length() || searchWord.equals(word)) {
                } else {
                    int count;
                    char[] w = word.toCharArray();
                    count = (int) IntStream.range(0, word.length()).filter(i -> w[i] != c[i]).count();
                    if (count == 1) return true;
                }
            return false;
        }
    }
}
