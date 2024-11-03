package main.java;

public class Solution_2385 {
    int max = 0;

    public int amountOfTime(TreeNode root, int start) {
        getHeight(root, start);
        return max;
    }

    int[] getHeight(TreeNode root, int start) {
        if (root == null) return new int[]{0, 0};
        int[] left = getHeight(root.left, start);
        int[] right = getHeight(root.right, start);
        if (root.val == start) {
            max = Math.max(left[1], right[1]);
            return new int[]{1, 0};
        }
        if (left[0] == 1) {
            max = Math.max(max, left[1] + 1 + right[1]);
            return new int[]{1, left[1] + 1};
        }
        if (right[0] == 1) {
            max = Math.max(max, right[1] + 1 + left[1]);
            return new int[]{1, right[1] + 1};
        }
        return new int[]{0, 1 + Math.max(left[1], right[1])};
    }
}
