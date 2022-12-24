package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1408 {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        if (words.length == 1) return list;
        boolean[] seen = new boolean[words.length];
        Arrays.sort(words, (word1, word2) -> (word2.length() - word1.length()));
        for (int i = 0; i < words.length - 1; i++)
            for (int j = i + 1; j < words.length; j++)
                if (words[i].contains(words[j]) && !seen[j]) {
                    seen[j] = true;
                    list.add(words[j]);
                }
        return list;
    }
}
