package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_95 {
    List<TreeNode> build(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        IntStream.rangeClosed(start, end).forEach(i -> {
            List<TreeNode> left = build(start, i - 1);
            List<TreeNode> right = build(i + 1, end);
            left.forEach(p1 -> right.forEach(p2 -> {
                TreeNode tr = new TreeNode(i);
                tr.left = p1;
                tr.right = p2;
                ans.add(tr);
            }));
        });
        return ans;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }
}
