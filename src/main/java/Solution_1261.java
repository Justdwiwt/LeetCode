package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_1261 {
   static class FindElements {
        private final Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            rebuildTree(root, null);
        }

        private void rebuildTree(TreeNode root, TreeNode parent) {
            if (root == null) return;
            root.val = parent == null ? 0 : root == parent.left ? (parent.val << 1) + 1 : (parent.val << 1) + 2;
            set.add(root.val);
            rebuildTree(root.left, root);
            rebuildTree(root.right, root);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
