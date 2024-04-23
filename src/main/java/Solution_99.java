package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_99 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        LDR(root, list1, list2);
        Collections.sort(list2);
        IntStream.range(0, list1.size()).forEach(i -> list1.get(i).val = list2.get(i));
    }

    public void LDR(TreeNode cur, List<TreeNode> list1, List<Integer> list2) {
        if (cur == null) return;
        LDR(cur.left, list1, list2);
        list1.add(cur);
        list2.add(cur.val);
        LDR(cur.right, list1, list2);
    }
}
