package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution_863 {
    HashMap<TreeNode, TreeNode> map;
    HashSet<TreeNode> visited;
    List<Integer> res;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        map = new HashMap<>();
        buildMap(root, target);
        res = new ArrayList<>();
        visited = new HashSet<>();
        dfs(target, K, 0);
        return res;
    }

    public void dfs(TreeNode cur, int K, int dis) {
        if (dis > K || cur == null || visited.contains(cur)) return;
        visited.add(cur);
        if (dis == K) res.add(cur.val);
        dfs(cur.left, K, dis + 1);
        dfs(cur.right, K, dis + 1);
        dfs(map.get(cur), K, dis + 1);
    }

    public void buildMap(TreeNode root, TreeNode target) {
        if (root == target) return;
        if (root.left != null) {
            map.put(root.left, root);
            buildMap(root.left, target);
        }
        if (root.right != null) {
            map.put(root.right, root);
            buildMap(root.right, target);
        }
    }
}
