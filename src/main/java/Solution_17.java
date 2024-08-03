package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) res = combination(res, str[digits.charAt(i) - '0' - 2]);
        return res;
    }

    public List<String> combination(List<String> s1, String s2) {
        List<String> str = new ArrayList<>();
        IntStream.range(0, s2.length()).forEach(i -> {
            if (s1.isEmpty()) str.add(s2.substring(i, i + 1));
            else s1.stream().map(s -> s + s2.charAt(i)).forEach(str::add);
        });
        return str;
    }
}
