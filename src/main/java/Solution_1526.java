package main.java;

import java.util.stream.IntStream;

public class Solution_1526 {
    public int minNumberOperations(int[] target) {
        int res = target[0];
        res += IntStream.range(1, target.length).filter(i -> target[i] > target[i - 1]).map(i -> target[i] - target[i - 1]).sum();
        return res;
    }
}
