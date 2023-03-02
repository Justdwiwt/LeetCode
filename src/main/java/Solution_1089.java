package main.java;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_1089 {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        IntStream.range(0, arr.length).forEach(i -> {
            queue.add(arr[i]);
            if (arr[i] == 0) queue.add(0);
            arr[i] = queue.poll();
        });
    }
}
