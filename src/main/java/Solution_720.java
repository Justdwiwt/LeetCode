package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String res = "";
        Set<String> set = new HashSet<>();
        set.add(res);
        for (String word : words)
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > res.length()) res = word;
            }
        return res;
    }
}
