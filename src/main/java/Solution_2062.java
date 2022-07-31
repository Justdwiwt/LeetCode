package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_2062 {
    public int countVowelSubstrings(String word) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u')), cur = new HashSet<>();
        int res = 0;
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++, cur.clear())
            for (int j = i; j < ch.length && vowels.contains(ch[j]); j++) {
                cur.add(ch[j]);
                res += cur.size() == vowels.size() ? 1 : 0;
            }
        return res;
    }
}
