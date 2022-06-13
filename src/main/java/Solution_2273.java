package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2273 {
    public List<String> removeAnagrams(String[] words) {
        char[][] ch = new char[words.length][];
        IntStream.range(0, words.length).forEach(i -> {
            ch[i] = words[i].toCharArray();
            Arrays.sort(ch[i]);
        });
        List<String> res = new ArrayList<>();
        for (int i = words.length - 2; i >= 0; i--)
            if (!Arrays.equals(ch[i], ch[i + 1]))
                res.add(words[i + 1]);
        res.add(words[0]);
        Collections.reverse(res);
        return res;
    }
}
