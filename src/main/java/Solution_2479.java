package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2479 {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    TrieNode root = new TrieNode();
    int bits = 46;
    long[] s;
    long res = 0;
    List<List<Integer>> adj = new ArrayList<>();

    void add(long val) {
        TrieNode node = root;
        for (int i = bits; i >= 0; i--) {
            int cur = (int) ((val >> i) & 1);
            if (node.child[cur] == null) node.child[cur] = new TrieNode();
            node = node.child[cur];
        }
    }

    long query(long val) {
        TrieNode node = root;
        long res = 0;
        for (int i = bits; i >= 0; i--) {
            int cur = (int) ((val >> i) & 1);
            if (node.child[1 - cur] != null) {
                res = res + (1L << i);
                node = node.child[1 - cur];
            } else if (node.child[cur] != null) node = node.child[cur];
            else return res;
        }
        return res;
    }

    long dfs(int node, int prev, int[] values) {
        long res = values[node] + adj.get(node).stream().filter(e -> !e.equals(prev)).mapToLong(e -> dfs(e, node, values)).sum();
        s[node] = res;
        return res;
    }

    void process(int node, int prev) {
        long ans = query(s[node]);
        if (ans > res) res = ans;
        adj.get(node).stream().filter(next -> !next.equals(prev)).forEach(next -> process(next, node));
        add(s[node]);
    }

    public long maxXor(int n, int[][] edges, int[] values) {
        s = new long[n];
        IntStream.range(0, n).forEach(i -> adj.add(new ArrayList<>()));
        IntStream.range(0, edges.length).forEach(i -> {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        });
        dfs(0, -1, values);
        process(0, -1);
        return res;
    }
}
