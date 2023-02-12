package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1192 {
    int[] num;
    int[] low;
    boolean[] flag;
    Map<Integer, List<Integer>> m = new HashMap<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        num = new int[n];
        low = new int[n];
        List<List<Integer>> arr = new ArrayList<>();
        flag = new boolean[n];
        connections.forEach(connection -> {
            int a = connection.get(0), b = connection.get(1);
            buildGraph(a, b);
            buildGraph(b, a);
        });
        flag[0] = true;
        dfs(0, 1, -1);
        boolean[] target = new boolean[n];
        IntStream.range(0, n).forEach(i -> {
            List<Integer> integers = m.get(i);
            for (Integer integer : integers) {
                if (low[integer] > num[i] && !target[integer]) {
                    target[i] = true;
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(integer);
                    arr.add(l);
                }
            }
        });
        return arr;
    }

    private void dfs(int start, int index, int parent) {
        List<Integer> arr = m.get(start);
        num[start] = index;
        low[start] = index;
        for (Integer integer : arr) {
            if (!flag[integer]) {
                flag[integer] = true;
                index++;
                dfs(integer, index, start);
            }
            if (integer != parent) low[start] = Math.min(low[start], low[integer]);
        }
    }

    private void buildGraph(int a, int b) {
        List<Integer> integers = m.get(a);
        if (integers == null) integers = new ArrayList<>();
        integers.add(b);
        m.put(a, integers);
    }
}
