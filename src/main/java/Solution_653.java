package main.java;

import java.util.HashSet;

public class Solution_653 {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hashset = new HashSet<>();
        return preOrder(root, hashset, k);
    }

    public boolean preOrder(TreeNode root, HashSet<Integer> hashset, int k) {
        if (root == null) return false;
        if (hashset.contains(k - root.val)) return true;
        hashset.add(root.val);
        return preOrder(root.left, hashset, k) || preOrder(root.right, hashset, k);
    }
}
