package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1361 {
    public boolean validateBinaryTreeNodes(int n, int[] l, int[] r) {
        int[] in = new int[n];

        for (int i = 0; i < n; ++i) {
            if (l[i] != -1) if (++in[l[i]] > 1) return false;
            if (r[i] != -1) if (++in[r[i]] > 1) return false;
        }

        int root = -1;
        for (int i = 0; i < n; ++i)
            if (in[i] == 0) {
                if (root != -1) return false;
                root = i;
            }
        if (root == -1) return false;

        int cnt = 0;
        boolean[] v = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(root);
        v[root] = true;

        while (!q.isEmpty()) {
            int ls = q.size();
            cnt += ls;

            while (ls-- > 0) {
                int cur = q.poll();
                if (l[cur] != -1) {
                    if (v[l[cur]]) return false;
                    q.offer(l[cur]);
                    v[l[cur]] = true;
                }
                if (r[cur] != -1) {
                    if (v[r[cur]]) return false;
                    q.offer(r[cur]);
                    v[r[cur]] = true;
                }
            }
        }

        return cnt == n;
    }
}
