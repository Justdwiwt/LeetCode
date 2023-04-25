package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_894 {
    private final Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (map.containsKey(N)) return map.get(N);
        List<TreeNode> list = new ArrayList<>();
        if (N == 1) {
            list.add(new TreeNode(0));
            return list;
        }

        for (int i = 1; i < N; i += 2) {
            List<TreeNode> leftList = allPossibleFBT(i);
            List<TreeNode> rightList = allPossibleFBT(N - i - 1);
            leftList.forEach(left -> rightList.forEach(right -> {
                TreeNode root = new TreeNode(0);
                root.left = left;
                root.right = right;
                list.add(root);
            }));
        }
        map.put(N, list);
        return list;
    }
}
