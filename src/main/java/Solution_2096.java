package main.java;


public class Solution_2096 {
    public String getDirections(TreeNode root, int a, int b) {
        TreeNode lca = findLca(root, a, b);

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        if (lca.val != a) traverse(lca, a, s1, 'U');

        if (lca.val != b) traverse2(lca, b, s2);

        s1.reverse();
        s2.reverse();

        return s1 + "" + s2;
    }

    private boolean traverse2(TreeNode root, int b, StringBuilder sb) {
        if (root == null) return false;
        if (root.val == b) return true;

        boolean left = traverse2(root.left, b, sb);
        if (left) {
            sb.append("L");
            return true;
        }
        boolean right = traverse2(root.right, b, sb);
        if (right) {
            sb.append("R");
            return true;
        }
        return false;
    }

    private boolean traverse(TreeNode root, int a, StringBuilder sb, Character ch) {
        if (root == null) return false;

        if (root.val == a) return true;

        boolean left = traverse(root.left, a, sb, ch);
        if (left) {
            sb.append(ch);
            return true;
        }
        boolean right = traverse(root.right, a, sb, ch);
        if (right) {
            sb.append(ch);
            return true;
        }
        return false;
    }


    private TreeNode findLca(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.val == a || root.val == b) return root;

        TreeNode left = findLca(root.left, a, b);
        TreeNode right = findLca(root.right, a, b);

        TreeNode res = null;

        if (left != null && right != null) return root;
        else if (left != null || right != null)
            if (root.val == a || root.val == b) res = root;
            else res = (left != null) ? left : right;

        return res;
    }
}
