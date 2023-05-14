package main.java;

import java.util.HashMap;
import java.util.HashSet;

public class Solution_839 {
    public static boolean similarity(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) res++;
            if (res > 2) return false;
        }
        return (res == 2 || res == 0);
    }

    public static void dfs(HashMap<Integer, HashSet<Integer>> graph, int i, boolean[] visit) {
        visit[i] = true;
        graph.get(i).stream().filter(j -> !visit[j]).forEach(j -> dfs(graph, j, visit));
    }

    public int numSimilarGroups(String[] strs) {
        int N = strs.length;
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!graph.containsKey(i)) graph.put(i, new HashSet<>());
            graph.get(i).add(i);
            for (int j = i + 1; j < N; j++)
                if (similarity(strs[i], strs[j])) {
                    if (!graph.containsKey(j)) graph.put(j, new HashSet<>());
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
        }
        int res = 0;
        boolean[] visit = new boolean[N];
        for (int i = 0; i < N; i++)
            if (!visit[i]) {
                res++;
                dfs(graph, i, visit);
            }
        return res;
    }
}
