package main.java;

import java.util.stream.IntStream;

public class Solution_1528 {
    public String restoreString(String s, int[] indices) {
        char[] ch = new char[s.length()];
        IntStream.range(0, indices.length).forEach(i -> ch[indices[i]] = s.charAt(i));
        return new String(ch);
    }
}
