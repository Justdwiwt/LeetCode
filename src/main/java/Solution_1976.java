package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1976 {
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int mod = (int) Math.pow(10, 9) + 7;
        ArrayList<ArrayList<Pair>> adj;
        adj = IntStream.range(0, n).mapToObj(i -> new ArrayList<Pair>()).collect(Collectors.toCollection(ArrayList::new));
        Arrays.stream(roads).forEach(road -> {
            int from = road[0];
            int to = road[1];
            int dis = road[2];
            adj.get(from).add(new Pair(to, dis));
            adj.get(to).add(new Pair(from, dis));
        });
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(aa -> aa.dist));
        pq.add(new Pair(0, 0));
        long[] ways = new long[n];
        ways[0] = 1;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int node = p.node;
            int dis = p.dist;
            adj.get(node).forEach(pa -> {
                if ((dis + pa.dist) < dist[pa.node]) {
                    ways[pa.node] = ways[node];
                    dist[pa.node] = dis + pa.dist;
                    pq.add(new Pair(pa.node, dist[pa.node]));
                } else if ((dis + pa.dist) == dist[pa.node]) {
                    ways[pa.node] += ways[node];
                    ways[pa.node] = ways[pa.node] % mod;
                }
            });
        }
        return (int) ways[n - 1];
    }
}
