package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1497 {
    public boolean canArrange(int[] arr, int k) {
        int[] bucket = new int[k];
        Arrays.stream(arr).forEach(value -> {
            int kk = value % k;
            if (kk < 0) kk += k;
            bucket[kk]++;
        });
        if (bucket[0] % 2 != 0) return false;
        return IntStream.rangeClosed(1, k / 2).allMatch(i -> bucket[i] == bucket[k - i]);
    }
}
