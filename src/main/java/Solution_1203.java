package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[] inDegree = new int[n + m];
        List<Integer>[] nei = IntStream.range(0, n + m).<List<Integer>>mapToObj(i -> new ArrayList<>()).toArray(List[]::new);
        IntStream.range(0, group.length).filter(i -> group[i] != -1).forEach(i -> {
            nei[group[i] + n].add(i);
            inDegree[i]++;
        });
        IntStream.range(0, beforeItems.size()).forEach(i -> {
            List<Integer> before = beforeItems.get(i);
            before.forEach(b -> {
                int curNode = (group[i] == -1 ? i : n + group[i]);
                int beforeNode = (group[b] == -1 ? b : n + group[b]);
                if (beforeNode == curNode) {
                    nei[b].add(i);
                    inDegree[i]++;
                } else {
                    nei[beforeNode].add(curNode);
                    inDegree[curNode]++;
                }
            });
        });
        IntStream.range(0, n + m).filter(i -> inDegree[i] == 0).forEach(i -> dfs(n, i, nei, inDegree));
        return (res.size() == n) ? res.stream().mapToInt(x -> x).toArray() : new int[]{};
    }

    List<Integer> res = new ArrayList<>();

    private void dfs(int n, int cur, List<Integer>[] ne, int[] inDegree) {
        if (cur < n) res.add(cur);
        inDegree[cur] = -1;
        ne[cur].stream().mapToInt(nei -> nei).filter(nei -> --inDegree[nei] == 0).forEach(nei -> dfs(n, nei, ne, inDegree));
    }
}
