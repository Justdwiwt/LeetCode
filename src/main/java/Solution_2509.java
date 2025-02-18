package main.java;

import java.util.Arrays;

public class Solution_2509 {
    int getPath(int i, int j) {
        return i == j ? 0 : i > j ? getPath(i / 2, j) + 1 : getPath(i, j / 2) + 1;
    }

    public int[] cycleLengthQueries(int n, int[][] queries) {
        return Arrays.stream(queries).mapToInt(query -> getPath(query[0], query[1]) + 1).toArray();
    }
}
