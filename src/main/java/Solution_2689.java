package main.java;

public class Solution_2689 {
    static class RopeTreeNode {
        int len;
        String val;
        RopeTreeNode left;
        RopeTreeNode right;

        RopeTreeNode() {
        }

        RopeTreeNode(String val) {
            this.len = 0;
            this.val = val;
        }

        RopeTreeNode(int len) {
            this.len = len;
            this.val = "";
        }

        RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
            this.len = len;
            this.val = "";
            this.left = left;
        }
    }

    public char getKthCharacter(RopeTreeNode root, int k) {
        if (root.len == 0) return root.val.charAt(k - 1);
        RopeTreeNode left = root.left;
        if (null == left) return getKthCharacter(root.right, k);
        if (left.len == 0) {
            if (k > left.val.length()) return getKthCharacter(root.right, k - left.val.length());
            return left.val.charAt(k - 1);
        }

        return left.len < k ? getKthCharacter(root.right, k - left.len) : getKthCharacter(root.left, k);
    }
}
