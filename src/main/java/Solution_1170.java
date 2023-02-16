package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        int[] array = Arrays.stream(words).mapToInt(Solution_1170::count).toArray();
        for (int i = 0; i < res.length; i++) {
            int count = count(queries[i]);
            for (int j = array.length - 1; j >= 0; j--)
                res[i] += count < array[j] ? 1 : 0;
        }
        return res;
    }

    private static int count(String str) {
        int[] alphabet = new int[26];
        IntStream.range(0, str.length()).forEach(i -> alphabet[str.charAt(i) - 'a']++);
        return Arrays.stream(alphabet).filter(count -> count != 0).findFirst().orElse(0);
    }
}
