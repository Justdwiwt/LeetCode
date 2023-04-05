package main.java;

import java.util.LinkedList;

public class Solution_958 {
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        TreeNode cur;
        while ((cur = q.removeFirst()) != null) {
            q.addLast(cur.left);
            q.addLast(cur.right);
        }
        while (!q.isEmpty())
            if (q.removeLast() != null) return false;
        return true;
    }
}
