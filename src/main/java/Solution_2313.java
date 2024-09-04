package main.java;

import javafx.util.Pair;

import java.util.HashMap;

public class Solution_2313 {
    int FALSE = 0;
    int TRUE = 1;

    int OR = 2;
    int AND = 3;
    int XOR = 4;
    int NOT = 5;
    HashMap<Pair<TreeNode, Boolean>, Integer> memo = new HashMap<>();

    public int minimumFlips(TreeNode root, boolean expect) {
        Pair<TreeNode, Boolean> key = new Pair<>(root, expect);
        if (memo.containsKey(key)) return memo.get(key);
        if (root == null) return 0;
        int ret = 0;
        if (root.val == FALSE) ret = (expect ? 1 : 0);
        if (root.val == TRUE) ret = (expect ? 0 : 1);
        if (root.val == OR)
            if (expect) ret = Math.min(minimumFlips(root.left, true), minimumFlips(root.right, true));
            else ret = minimumFlips(root.left, false) + minimumFlips(root.right, false);
        if (root.val == AND)
            if (expect) ret = minimumFlips(root.left, true) + minimumFlips(root.right, true);
            else ret = Math.min(minimumFlips(root.left, false), minimumFlips(root.right, false));
        if (root.val == XOR) {
            int lf = minimumFlips(root.left, false);
            int lt = minimumFlips(root.left, true);
            int rf = minimumFlips(root.right, false);
            int rt = minimumFlips(root.right, true);
            if (expect) ret = Math.min(lf + rt, lt + rf);
            else ret = Math.min(lf + rf, lt + rt);
        }
        if (root.val == NOT)
            ret = root.left == null ? minimumFlips(root.right, !expect) : minimumFlips(root.left, !expect);
        memo.put(key, ret);
        return ret;
    }
}
