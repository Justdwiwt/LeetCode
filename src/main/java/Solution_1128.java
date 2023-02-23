package main.java;

import java.util.Arrays;

public class Solution_1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] arr = new int[10][10];
        return Arrays.stream(dominoes).mapToInt(d -> d[0] < d[1] ? arr[d[0]][d[1]]++ : arr[d[1]][d[0]]++).sum();
    }
}
