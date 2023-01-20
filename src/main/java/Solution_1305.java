package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        return merge(inorderTraversal(root1, new ArrayList<>()), inorderTraversal(root2, new ArrayList<>()));
    }

    public List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }
        if (i == list1.size()) for (; j < list2.size(); j++) res.add(list2.get(j));
        else for (; i < list1.size(); i++) res.add(list1.get(i));
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode t, List<Integer> res) {
        if (t != null) {
            inorderTraversal(t.left, res);
            res.add(t.val);
            inorderTraversal(t.right, res);
        }
        return res;
    }
}
