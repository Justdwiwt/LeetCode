package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_106 {
    private final Map<Integer, Integer> map = new HashMap<>();
    private int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        IntStream.range(0, inorder.length).forEach(i -> map.put(inorder[i], i));
        idx = postorder.length - 1;
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int l, int r) {
        if (r < l) return null;
        int mid = map.get(postorder[idx]);
        TreeNode node = new TreeNode(postorder[idx--]);
        node.right = build(postorder, mid + 1, r);
        node.left = build(postorder, l, mid - 1);
        return node;
    }
}
