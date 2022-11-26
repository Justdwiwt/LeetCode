package main.java;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_1525 {
    public int numSplits(String s) {
        int res;
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] preSum = new int[n];
        int[] posSum = new int[n + 1];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        IntStream.range(0, n).forEach(i -> {
            set1.add(chars[i]);
            preSum[i] = set1.size();
        });
        for (int i = n - 1; i >= 0; i--) {
            set2.add(chars[i]);
            posSum[i] = set2.size();
        }
        res = (int) IntStream.range(0, n).filter(i -> preSum[i] == posSum[i + 1]).count();
        return res;
    }
}
