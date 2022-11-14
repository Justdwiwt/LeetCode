package main.java;

import java.util.stream.IntStream;

public class Solution_1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        IntStream.range(0, n).forEach(i -> prefix[i + 1] = prefix[i] + arr[i]);
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j >= 0; j -= 2)
                res += prefix[i + 1] - prefix[j];
        return res;
    }
}
