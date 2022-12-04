package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1489 {
    int[] father = new int[101];

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        IntStream.range(0, m).forEach(i -> {
            System.arraycopy(edges[i], 0, newEdges[i], 0, 3);
            newEdges[i][3] = i;
        });
        Arrays.sort(newEdges, Comparator.comparingInt(x -> x[2]));

        int min_cost = f(n, newEdges, -1);

        List<List<Integer>> res = IntStream.range(0, 2)
                .<List<Integer>>mapToObj(i -> new ArrayList<>())
                .collect(Collectors.toList());

        IntStream.range(0, m).forEach(i -> {
            if (f(n, newEdges, i) > min_cost) res.get(0).add(i);
            else if (g(n, newEdges, i) == min_cost) res.get(1).add(i);
        });
        return res;
    }

    int f(int n, int[][] edges, int i) {
        IntStream.range(0, n).forEach(j -> father[j] = j);
        int cost = 0, cnt = 0;
        for (int[] e : edges) {
            if (e[3] == i) continue;
            int fa1 = findFather(e[0]);
            int fa2 = findFather(e[1]);
            if (fa1 != fa2) {
                father[fa1] = fa2;
                cost += e[2];
                cnt++;
                if (cnt == n - 1) break;
            }
        }
        return cnt == n - 1 ? cost : Integer.MAX_VALUE;
    }

    int g(int n, int[][] edges, int i) {
        IntStream.range(0, n).forEach(j -> father[j] = j);
        int cost = 0, cnt = 0;
        for (int[] e : edges)
            if (e[3] == i) {
                father[e[0]] = e[1];
                cost += e[2];
                cnt++;
                break;
            }
        for (int[] e : edges) {
            if (e[3] == i) continue;
            int fa1 = findFather(e[0]);
            int fa2 = findFather(e[1]);
            if (fa1 != fa2) {
                father[fa1] = fa2;
                cost += e[2];
                cnt++;
                if (cnt == n - 1) break;
            }
        }
        return cnt == n - 1 ? cost : Integer.MAX_VALUE;
    }

    int findFather(int x) {
        if (father[x] != x)
            father[x] = findFather(father[x]);
        return father[x];
    }
}
