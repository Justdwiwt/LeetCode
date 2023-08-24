package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n1 = s.length();
        int n2 = p.length();
        if (n2 > n1) return res;
        int[] sInt = new int[26];
        int[] pInt = new int[26];
        IntStream.range(0, n2).forEach(i -> {
            sInt[s.charAt(i) - 'a']++;
            pInt[p.charAt(i) - 'a']++;
        });
        if (Arrays.equals(sInt, pInt)) res.add(0);
        IntStream.range(n2, n1).forEach(i -> {
            sInt[s.charAt(i - n2) - 'a']--;
            sInt[s.charAt(i) - 'a']++;
            if (Arrays.equals(sInt, pInt)) res.add(i - n2 + 1);
        });
        return res;
    }
}
