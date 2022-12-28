package main.java;

import java.util.stream.IntStream;

public class Solution_1394 {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        IntStream.range(0, arr.length).forEach(i -> freq[arr[i]]++);
        for (int i = 500; i > 0; i--)
            if (freq[i] == i) return i;
        return -1;
    }
}
