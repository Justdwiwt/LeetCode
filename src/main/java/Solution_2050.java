package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2050 {
    public int minimumTime(int n, int[][] dependencies, int[] time) {
        List<Integer>[] graph = IntStream.range(0, n).<List<Integer>>mapToObj(i -> new ArrayList<>()).toArray(ArrayList[]::new);
        int[] inDegree = new int[n];
        Arrays.stream(dependencies).forEach(dependency -> {
            graph[dependency[0] - 1].add(dependency[1] - 1);
            inDegree[dependency[1] - 1]++;
        });
        Queue<Integer> q = IntStream.range(0, n).filter(i -> inDegree[i] == 0).boxed().collect(Collectors.toCollection(LinkedList::new));
        int[] dp = new int[n];
        while (!q.isEmpty()) {
            int size = q.size();
            IntStream.range(0, size).map(i -> q.poll()).forEach(cur -> {
                dp[cur] += time[cur];
                graph[cur].forEach(nei -> {
                    if (--inDegree[nei] == 0) q.add(nei);
                    dp[nei] = Math.max(dp[cur], dp[nei]);
                });
            });
        }
        int max = 0;
        for (int d : dp) max = Math.max(max, d);
        return max;
    }
}
