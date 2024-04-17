package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_105 {
    private final Map<Integer, Integer> m = new HashMap<>();
    private int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        IntStream.range(0, inorder.length).forEach(i -> m.put(inorder[i], i));
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int l, int r) {
        if (r < l) return null;
        int mid = m.get(preorder[idx]);
        TreeNode node = new TreeNode(preorder[idx++]);
        node.left = build(preorder, l, mid - 1);
        node.right = build(preorder, mid + 1, r);
        return node;
    }
}
