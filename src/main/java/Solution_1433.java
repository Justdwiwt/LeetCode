package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return beatUp(c1, c2) || beatUp(c2, c1);
    }

    private boolean beatUp(char[] c1, char[] c2) {
        return IntStream.range(0, c1.length).noneMatch(i -> c1[i] > c2[i]);
    }
}
