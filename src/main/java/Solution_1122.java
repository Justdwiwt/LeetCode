package main.java;

import java.util.stream.IntStream;

public class Solution_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        IntStream.range(0, arr1.length).forEach(i -> bucket[arr1[i]]++);
        int idx = 0;
        for (int j : arr2)
            while (bucket[j] > 0) {
                bucket[j]--;
                arr1[idx++] = j;
            }
        for (int i = 0; i < bucket.length; i++)
            while (bucket[i] > 0) {
                bucket[i]--;
                arr1[idx++] = i;
            }
        return arr1;
    }
}
