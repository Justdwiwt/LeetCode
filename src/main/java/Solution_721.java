package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_721 {
    private int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new int[10000];
        IntStream.range(0, 10000).forEach(i -> parent[i] = i);
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        for (List<String> account : accounts) {
            String name = "";
            String first = account.get(1);
            for (String s : account) {
                if (name.length() < 1) {
                    name = s;
                    continue;
                }
                emailToName.putIfAbsent(s, name);
                emailToId.putIfAbsent(s, id++);
                union(emailToId.get(first), emailToId.get(s));
            }
        }
        Map<Integer, List<String>> ans = new HashMap<>();
        emailToName.keySet().forEach(email -> {
            int par = find(emailToId.get(email));
            ans.computeIfAbsent(par, v -> new ArrayList<>()).add(email);
        });
        ans.values().forEach(component -> {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        });
        return new ArrayList<>(ans.values());
    }

    private int find(int node) {
        return parent[node] == node ? node : (parent[node] = find(parent[node]));
    }

    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 == root2) return;
        parent[root1] = root2;
    }
}
