package main.java;

import java.util.Arrays;
import java.util.BitSet;

public class Solution_888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int maxLen = 100001, len2 = B.length;
        BitSet set = new BitSet(maxLen);
        int sumA = 0, sumB;
        for (int j : A) {
            sumA += j;
            set.set(j);
        }
        sumB = Arrays.stream(B, 0, len2).sum();
        int left = (sumA - sumB) / 2;
        for (int j : B) if (j + left > 0 && set.get(j + left)) return new int[]{j + left, j};
        return null;
    }
}
