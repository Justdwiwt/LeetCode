package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_135 {
    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);
        IntStream.range(1, ratings.length).filter(i -> ratings[i] > ratings[i - 1]).forEach(i -> arr[i] = arr[i - 1] + 1);
        for (int i = ratings.length - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1]) arr[i] = Math.max(arr[i], arr[i + 1] + 1);
        return Arrays.stream(arr).sum();
    }
}
