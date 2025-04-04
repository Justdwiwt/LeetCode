package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int m = words.length;
        int[] sum = new int[m + 1];
        IntStream.range(0, m).forEach(i -> sum[i + 1] = sum[i] + ("aeoiu".indexOf(words[i].charAt(0)) > -1 && "aeiou".lastIndexOf(words[i].charAt(words[i].length() - 1)) > -1 ? 1 : 0));
        return Arrays.stream(queries).mapToInt(query -> sum[query[1] + 1] - sum[query[0]]).toArray();
    }
}
