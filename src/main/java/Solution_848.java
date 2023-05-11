package main.java;

import java.util.stream.IntStream;

public class Solution_848 {
    public String shiftingLetters(String S, int[] shifts) {
        char[] ch = S.toCharArray();
        for (int i = shifts.length - 2; i >= 0; i--) shifts[i] += shifts[i + 1] % 26;
        IntStream.range(0, ch.length).forEach(i -> ch[i] = (char) ((ch[i] - 'a' + shifts[i]) % 26 + 'a'));
        return String.valueOf(ch);
    }
}
