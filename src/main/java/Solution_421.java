package main.java;

public class Solution_421 {
    public static class Node {
        public Node[] next = new Node[2];
    }

    public static class Trie {
        Node head = new Node();

        public void add(int newNum) {
            Node cur = head;
            for (int i = 31; i >= 0; i--) {
                int path = (newNum >> i) & 1;
                cur.next[path] = cur.next[path] == null ? new Node() : cur.next[path];
                cur = cur.next[path];
            }
        }

        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int i = 31; i >= 0; i--) {
                int path = (num >> i) & 1;
                int best = i == 31 ? path : path ^ 1;
                best = cur.next[best] != null ? best : best ^ 1;
                res |= (path ^ best) << i;
                cur = cur.next[best];
            }
            return res;
        }
    }

    public static int findMaximumXOR(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int N = arr.length;
        Trie trie = new Trie();
        trie.add(arr[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            max = Math.max(max, trie.maxXor(arr[i]));
            trie.add(arr[i]);
        }
        return max;
    }
}
