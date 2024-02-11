package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_173 {
    static class BSTIterator {
        int idx = 0;
        List<Integer> list = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }

        public int next() {
            return list.get(idx++);
        }

        public boolean hasNext() {
            return idx < list.size();
        }
    }
}
