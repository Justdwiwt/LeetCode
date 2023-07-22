package main.java;

public class Solution_559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (Node child : root.children) max = Math.max(maxDepth(child), max);
        return max + 1;
    }
}
