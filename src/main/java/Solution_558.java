package main.java;

public class Solution_558 {
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        return build(quadTree1, quadTree2);
    }

    private Node build(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf || quadTree2.isLeaf)
            if (quadTree1.isLeaf && quadTree2.isLeaf)
                return new Node(quadTree1.val | quadTree2.val, true, null, null, null, null);
            else if (quadTree1.isLeaf)
                return quadTree1.val ? new Node(true, true, null, null, null, null) : quadTree2;
            else return quadTree2.val ? new Node(true, true, null, null, null, null) : quadTree1;
        else {
            Node topLeft = build(quadTree1.topLeft, quadTree2.topLeft);
            Node topRight = build(quadTree1.topRight, quadTree2.topRight);
            Node bottomLeft = build(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node bottomRight = build(quadTree1.bottomRight, quadTree2.bottomRight);
            return topLeft.val && topLeft.isLeaf && topRight.val && topRight.isLeaf && bottomLeft.val && bottomLeft.isLeaf && bottomRight.val && bottomRight.isLeaf
                    ? new Node(true, true, null, null, null, null)
                    : new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
