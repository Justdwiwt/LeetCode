package main.java;

public class Solution_1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return ((head.val == root.val && isSubPath(head, root, true)) || isSubPath(head, root, false));
    }

    public boolean isSubPath(ListNode head, TreeNode root, boolean flag) {
        if (root == null) return false;
        if (head.val == root.val && (head.next == null || isSubPath(head.next, root.left, true) || isSubPath(head.next, root.right, true)))
            return true;
        else if (flag) return false;
        return (isSubPath(head, root.left, false) || isSubPath(head, root.right, false));
    }
}
