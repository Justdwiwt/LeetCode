package main.java;

public class Solution_427 {
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return fun(grid, 0, grid[0].length, 0, grid.length);
    }

    public Node fun(int[][] grid, int left, int right, int top, int bottom) {
        Node root;
        int key = grid[top][left];
        for (int i = top; i < bottom; i++)
            for (int j = left; j < right; j++)
                if (grid[i][j] != key) {
                    Node topLeft = fun(grid, left, (left + right) / 2, top, (top + bottom) / 2);
                    Node topRight = fun(grid, (left + right) / 2, right, top, (top + bottom) / 2);
                    Node bottomLeft = fun(grid, left, (left + right) / 2, (top + bottom) / 2, bottom);
                    Node bottomRight = fun(grid, (left + right) / 2, right, (top + bottom) / 2, bottom);
                    root = new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
                    return root;
                }
        root = new Node();
        root.val = key == 1;
        root.isLeaf = true;
        return root;
    }
}
