package main.java;

import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
public class Solution_590 {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;

        LinkedList<Node> l = new LinkedList<>();
        l.add(root);

        while(!l.isEmpty()){
            Node t = l.pollLast();
            t.children.forEach(l::addLast);
            res.addFirst(t.val);
        }

        return res;
    }
}
