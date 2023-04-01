package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_971 {
    List<Integer> res = new ArrayList<>();
    int p = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return doVoyage(root, voyage) && p == voyage.length ? res : new ArrayList<Integer>() {{
            add(-1);
        }};
    }

    private boolean doVoyage(TreeNode node, int[] voyage) {
        if (node == null) return true;
        if (node.val != voyage[p]) return false;
        p++;
        if (node.left != null && node.left.val != voyage[p]) {
            TreeNode tem = node.left;
            node.left = node.right;
            node.right = tem;
            res.add(node.val);
        }
        return doVoyage(node.left, voyage) && doVoyage(node.right, voyage);
    }
}
