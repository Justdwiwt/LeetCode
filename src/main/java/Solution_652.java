package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_652 {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }


    private String dfs(TreeNode root) {
        if (root == null) return "#";
        String s = root.val + " " + dfs(root.left) + " " + dfs(root.right);
        if (map.containsKey(s) && map.get(s) == 1) res.add(root);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}
