package main.java;

import java.util.Arrays;

public class Solution_2935 {
    static class TrieNode {

        TrieNode[] children;

        int cnt;

        TrieNode() {
            children = new TrieNode[2];
            cnt = 0;
        }
    }

    private TrieNode root;

    private void insert(int num) {
        TrieNode node = root;
        for (int i = 20; i >= 0; i--) {
            int bit = num >> i & 1;
            if (node.children[bit] == null) node.children[bit] = new TrieNode();
            node = node.children[bit];
            node.cnt++;
        }
    }

    private void remove(int num) {
        TrieNode node = root;
        for (int i = 20; i >= 0; i--) {
            int bit = num >> i & 1;
            node = node.children[bit];
            node.cnt--;
        }
    }

    private int query(int num) {
        int ans = 0;
        TrieNode node = root;
        for (int i = 20; i >= 0; i--) {
            int bit = num >> i & 1;
            if (node.children[bit ^ 1] != null && node.children[bit ^ 1].cnt > 0) {
                node = node.children[bit ^ 1];
                ans |= 1 << i;
            } else node = node.children[bit];
        }
        return ans;
    }

    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = 0;
        root = new TrieNode();
        for (int i = 0, j = 0; i < n; i++) {
            int num = nums[i];
            insert(num);
            while (j <= i && num - nums[j] > nums[j]) remove(nums[j++]);
            ans = Math.max(ans, query(num));
        }

        return ans;
    }
}
