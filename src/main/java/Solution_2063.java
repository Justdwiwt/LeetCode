package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2063 {
    public long countVowels(String word) {
        long[] arr = new long[word.length() + 1];
        IntStream.rangeClosed(1, word.length()).forEach(i -> {
            arr[i] = arr[i - 1];
            if ("aeiou".indexOf(word.charAt(i - 1)) != -1) arr[i] += i;
        });
        return Arrays.stream(arr).sum();
    }
}
