package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2186 {
    public int minSteps(String s, String t) {
        int[] arr = new int[26];

        IntStream.range(0, s.length()).forEach(i -> arr[s.charAt(i) - 'a']++);
        IntStream.range(0, t.length()).forEach(i -> arr[t.charAt(i) - 'a']--);

        return Arrays.stream(arr)
                .map(Math::abs)
                .sum();
    }
}
