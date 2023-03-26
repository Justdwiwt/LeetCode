package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> list = new ArrayList<>();
        dfs(root, list, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        list.sort((o1, o2) -> o1.col == o2.col ? o1.row == o2.row ? o1.value - o2.value : o1.row - o2.row : o1.col - o2.col);
        int idx = 0;

        while (idx < list.size()) {
            List<Integer> tmp = new ArrayList<>();
            int pre = Integer.MAX_VALUE;
            while (tmp.size() == 0 || (pre == list.get(idx).col)) {
                pre = list.get(idx).col;
                tmp.add(list.get(idx++).value);
                if (idx >= list.size()) break;
            }
            res.add(tmp);
        }
        return res;
    }

    private void dfs(TreeNode root, List<Node> list, int row, int col) {
        if (root == null) return;
        Node curNode = new Node(row, col, root.val);
        list.add(curNode);
        if (root.left != null) dfs(root.left, list, row + 1, col - 1);
        if (root.right != null) dfs(root.right, list, row + 1, col + 1);
    }

    static class Node {
        int row;
        int col;
        int value;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
