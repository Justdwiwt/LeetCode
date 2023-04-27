package main.java;

public class Solution_889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return f(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode f(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) return root;
        int idx = 0;
        while (post[idx] != pre[preStart + 1]) idx++;
        root.left = f(pre, post, preStart + 1, preStart + 1 + idx - postStart, postStart, idx);
        root.right = f(pre, post, preStart + 2 + idx - postStart, preEnd, idx + 1, preEnd - 1);
        return root;
    }
}
