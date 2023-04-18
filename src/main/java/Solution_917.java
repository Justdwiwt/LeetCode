package main.java;

import java.util.stream.IntStream;

public class Solution_917 {
    public String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = ch.length - 1; i >= 0; i--)
            if ((ch[i] <= 122 && ch[i] >= 97) || (ch[i] <= 90 && ch[i] >= 65)) sb.append(ch[i]);
        IntStream.range(0, ch.length).filter(i -> (ch[i] > 122 || ch[i] < 97) && (ch[i] > 90 || ch[i] < 65)).forEach(i -> sb.insert(i, ch[i]));
        return sb.toString();
    }
}
