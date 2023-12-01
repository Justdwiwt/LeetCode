package main.java;

import java.util.LinkedList;

public class Solution_297 {
    public static class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return null;
            StringBuilder res = new StringBuilder();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node != null) {
                    res.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else res.append("null,");
            }
            return res.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] dataArr = data.split(",");
            int index = 0;
            TreeNode root = toNode(dataArr[index]);
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (index < dataArr.length - 2 && !queue.isEmpty()) {
                TreeNode cur = queue.remove();
                TreeNode leftNode = toNode(dataArr[++index]);
                cur.left = leftNode;
                if (leftNode != null) queue.add(leftNode);
                TreeNode rightNode = toNode(dataArr[++index]);
                cur.right = rightNode;
                if (rightNode != null) queue.add(rightNode);
            }
            return root;
        }

        private TreeNode toNode(String val) {
            return !"null".equals(val) ? new TreeNode(Integer.parseInt(val)) : null;
        }
    }
}
