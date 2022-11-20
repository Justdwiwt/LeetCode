package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] arr = new int[n];
        edges.forEach(ls -> arr[ls.get(1)]++);
        return IntStream.range(0, n).filter(i -> arr[i] == 0).boxed().collect(Collectors.toList());
    }
}
