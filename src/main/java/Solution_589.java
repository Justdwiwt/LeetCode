package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_589 {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if(root == null) return res;
        res.add(root.val);
        root.children.forEach(this::preorder);
        return res;
    }
}
