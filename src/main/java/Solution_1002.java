package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class Solution_1002 {
    public List<String> commonChars(String[] A) {
        return Arrays.stream(A)
                .map(String::toCharArray)
                .map(chars -> {
                    int[] flags = new int[26];
                    for (char c : chars) flags[c - 'a']++;
                    return flags;
                })
                .reduce((m1, m2) -> {
                    IntStream.range(0, 26).forEach(i -> m1[i] = Math.min(m1[i], m2[i]));
                    return m1;
                })
                .map(flag -> {
                    List<String> res = new ArrayList<>();
                    for (int i = 0; i < 26; i++)
                        for (int j = 0; j < flag[i]; j++)
                            res.add(String.valueOf((char) (i + 'a')));
                    return res;
                })
                .get();
    }
}
