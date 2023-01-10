package main.java;

import java.util.stream.IntStream;

public class Solution_1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int[] prefixSum = new int[arr.length + 1];
        IntStream.range(1, prefixSum.length).forEach(i -> prefixSum[i] = prefixSum[i - 1] + arr[i - 1]);
        for (int i = 0; i + k <= arr.length; i++)
            if ((prefixSum[i + k] - prefixSum[i]) / k >= threshold) res++;
        return res;
    }
}
