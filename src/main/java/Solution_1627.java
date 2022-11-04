package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1627 {
    private int[] arr;

    private int find(int x) {
        return arr[x] == x ? arr[x] : (arr[x] = find(arr[x]));
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> res;
        arr = new int[n + 1];
        IntStream.rangeClosed(1, n).forEach(i -> arr[i] = i);

        for (int i = threshold + 1; i <= n; i++)
            for (int j = i * 2; j <= n; j += i)
                if (find(i) != find(j)) arr[find(j)] = find(i);

        res = Arrays.stream(queries).map(query -> find(query[0]) == find(query[1])).collect(Collectors.toList());
        return res;
    }
}
