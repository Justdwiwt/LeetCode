package main.java;

import javafx.util.Pair;

import java.util.*;

public class Solution_1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, HashMap<Integer, Double>> graph = new HashMap<>();
        Map<Integer, Double> distance = new HashMap<>();
        int idx = 0;
        for (int[] edge : edges) {
            distance.putIfAbsent(edge[0], 0D);
            distance.putIfAbsent(edge[1], 0D);
            graph.putIfAbsent(edge[0], new HashMap<>());
            graph.putIfAbsent(edge[1], new HashMap<>());
            double sp = succProb[idx++];
            graph.get(edge[0]).put(edge[1], sp);
            graph.get(edge[1]).put(edge[0], sp);
        }
        if (!graph.containsKey(start) || !graph.containsKey(end)) return 0D;
        distance.put(start, 1D);
        Queue<Pair<Double, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getKey() - o2.getKey() > 0 ? -1 : 1);
        pq.add(new Pair<>(1D, start));
        Set<Integer> seen = new HashSet<>();
        while (!pq.isEmpty()) {
            Pair<Double, Integer> poll = pq.poll();
            double sp = poll.getKey();
            int vertex = poll.getValue();
            seen.add(vertex);
            Set<Integer> nodes = graph.get(vertex).keySet();
            nodes.stream().filter(w -> !seen.contains(w)).forEach(w -> {
                double curSp = sp * graph.get(vertex).get(w);
                if (curSp > distance.get(w)) {
                    distance.put(w, curSp);
                    pq.add(new Pair<>(curSp, w));
                }
            });
        }
        return distance.get(end);
    }
}
