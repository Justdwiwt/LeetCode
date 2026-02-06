package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_3016 {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c - 'a']++;
        Arrays.sort(count);
        return IntStream.range(0, 26).map(i -> (i / 8 + 1) * count[25 - i]).sum();
    }
}
