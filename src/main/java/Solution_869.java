package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_869 {
    public boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i > 0; i <<= 1) set.add(numToStr(i));
        return set.contains(numToStr(n));
    }

    private String numToStr(int i) {
        char[] c = String.valueOf(i).toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
