package main.java;

public class Solution_437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int count = getPreSumTree(root, targetSum);
        return count + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int getPreSumTree(TreeNode root, long sum) {
        if (root == null) return 0;
        int temp = 0;
        sum -= root.val;
        if (sum == 0) temp++;
        return temp + getPreSumTree(root.left, sum) + getPreSumTree(root.right, sum);
    }
}
