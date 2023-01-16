package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1319 {
    final int N = (int) 1e5 + 10;
    int[] p = new int[N];

    public int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public int makeConnected(int n, int[][] connections) {
        int size = connections.length;
        if (size < n - 1) return -1;
        IntStream.range(0, n).forEach(i -> p[i] = i);
        Arrays.stream(connections).forEach(connection -> {
            int pa = find(connection[0]), pb = find(connection[1]);
            p[pa] = pb;
        });
        int len = (int) IntStream.range(0, n).filter(i -> find(i) == i).count();
        return len - 1;
    }
}
