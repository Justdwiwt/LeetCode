package main.java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_2471 {
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int[] arr = new int[size];
            while (size > 0) {
                TreeNode curNode = deque.pollFirst();
                assert curNode != null;
                arr[arr.length - size] = curNode.val;
                if (curNode.left != null) deque.offerLast(curNode.left);
                if (curNode.right != null) deque.offerLast(curNode.right);
                size--;
            }
            for (int i = 0; i < arr.length; i++) {
                int index = findMin(arr, i);
                if (index != i) {
                    arr[index] ^= arr[i];
                    arr[i] ^= arr[index];
                    arr[index] ^= arr[i];
                    ans++;
                }
            }
        }
        return ans;
    }

    public int findMin(int[] arr, int start) {
        int idx = start;
        for (int i = start + 1; i < arr.length; i++) if (arr[idx] > arr[i]) idx = i;
        return idx;
    }
}
