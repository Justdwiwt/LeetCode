package main.java;

public class Solution_1666 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node flipBinaryTree(Node root, Node leaf) {
        dfs(leaf, leaf, true);
        return leaf;
    }

    private void dfs(Node root, Node last, boolean isLeft) {
        if (root == null) return;
        Node parent = root.parent;
        if (parent != null) {
            if (root == last) {
                root.left = parent;
                root.parent = null;
            } else {
                if (!isLeft) root.right = root.left;
                root.left = parent;
                root.parent = last;
            }
            isLeft = parent.left == root;

        } else {
            root.parent = last;
            if (isLeft) root.left = null;
            else root.right = null;
        }
        dfs(parent, root, isLeft);
    }
}
