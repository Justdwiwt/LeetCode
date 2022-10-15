package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution_1707 {
    static class TrieNode {

        int cnt;

        TrieNode[] chs;

        TrieNode() {
            cnt = 0;
            chs = new TrieNode[2];
        }
    }

    private TrieNode root;

    void insert(int num) {
        TrieNode node = root;
        node.cnt++;
        for (int i = 29; i >= 0; i--) {
            int cur = (num >> i) & 1;
            if (node.chs[cur] == null) node.chs[cur] = new TrieNode();
            node.cnt++;
            node = node.chs[cur];
        }
    }

    int query(int num) {
        TrieNode node = root;
        int res = 0;
        for (int i = 29; i >= 0; i--) {
            int cur = ((num >> i) & 1) ^ 1;
            if (node.chs[cur] != null) {
                res += 1 << i;
                node = node.chs[cur];
            } else if (node.chs[cur ^ 1] != null)
                node = node.chs[cur ^ 1];
            else return -1;
        }
        return res;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int[] res = new int[m];
        int[][] q = new int[m][3];
        IntStream.range(0, m).forEach(i -> {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        });
        Arrays.sort(nums);
        Arrays.sort(q, Comparator.comparingInt(o -> o[1]));
        root = new TrieNode();
        for (int i = 0, j = 0; i < m; i++) {
            while (j < n && nums[j] <= q[i][1]) insert(nums[j++]);
            res[q[i][2]] = query(q[i][0]);
        }
        return res;
    }
}
