package main.java;

import java.util.stream.IntStream;

public class Solution_481 {
    public int magicalString(int n) {
        int[] arr = new int[n + 10];
        arr[0] = 1;
        arr[1] = arr[2] = 2;
        int end = 2, p1 = 1, p2 = 3;
        while (p2 < n) {
            p1++;
            end = 3 - end;
            for (int i = 0; i < arr[p1]; i++) {
                arr[p2] = end;
                p2++;
            }
        }
        return (int) IntStream.range(0, n).filter(i -> arr[i] == 1).count();
    }
}
