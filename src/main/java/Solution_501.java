package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_501 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> fre = new ArrayList<>();
        map.forEach((k, v) -> fre.add(v));
        Collections.sort(fre);
        int maxFre = fre.get(fre.size() - 1);
        return map
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxFre)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        dfs(node.right);
    }
}
