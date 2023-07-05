package main.java;

public class Solution_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        int idx = l;
        for (int i = l + 1; i <= r; i++)
            if (nums[i] > nums[idx]) idx = i;
        return new TreeNode(nums[idx], build(nums, l, idx - 1), build(nums, idx + 1, r));
    }
}
