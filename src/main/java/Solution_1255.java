package main.java;

import java.util.stream.IntStream;

public class Solution_1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int res = 0;
        int[] count = new int[26];
        IntStream.range(0, letters.length).forEach(i -> count[letters[i] - 'a']++);
        int k = (int) Math.pow(2, words.length);
        for (int i = 0; i < k; i++) {
            int[] c = countLetters(words, i);
            if (enough(count, c)) {
                int s = IntStream.range(0, 26).map(p -> c[p] * score[p]).sum();
                res = Math.max(res, s);
            }
        }
        return res;
    }

    public int[] countLetters(String[] words, int k) {
        int[] c = new int[26];
        for (String word : words) {
            if (k % 2 == 1)
                IntStream.range(0, word.length()).forEach(j -> c[word.charAt(j) - 'a']++);
            k /= 2;
        }
        return c;
    }

    public boolean enough(int[] count, int[] c) {
        return IntStream.range(0, 26).noneMatch(i -> count[i] < c[i]);
    }
}
