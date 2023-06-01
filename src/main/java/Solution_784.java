package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_784 {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        res.add(s);
        backTrack(s.toCharArray(), 0);
        return res;
    }

    private void backTrack(char[] chars, int start) {
        IntStream.range(start, chars.length).filter(i -> chars[i] > '9').forEach(i -> {
            chars[i] ^= 32;
            res.add(String.valueOf(chars));
            backTrack(chars, i + 1);
            chars[i] ^= 32;
        });
    }
}
