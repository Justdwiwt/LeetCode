package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] chars = new int[26];
        IntStream.range(0, allowed.length()).forEach(i -> chars[allowed.charAt(i) - 'a']++);
        return Arrays.stream(words).mapToInt(word -> check(chars, word)).sum();
    }

    private static int check(int[] chars, String word) {
        for (int i = 0; i < word.length(); i++)
            if (chars[word.charAt(i) - 'a'] <= 0)
                return 0;
        return 1;
    }
}
