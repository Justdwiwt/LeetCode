package main.java;

public class Solution_2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2) return node2;
        int[] vis = new int[edges.length];
        vis[node1] = 1;
        vis[node2] = 2;
        int len = 0;
        int res = edges.length;
        int min = edges.length;
        while (edges[node1] != -1 || edges[node2] != -1) {
            len++;
            if (len > min) break;
            if (edges[node1] != -1) {
                node1 = edges[node1];
                if (vis[node1] == 2) {
                    min = len;
                    res = Math.min(res, node1);
                }
                vis[node1] = 1;
            }

            if (edges[node2] != -1) {
                node2 = edges[node2];
                if (vis[node2] == 1) {
                    min = len;
                    res = Math.min(res, node2);
                }
                vis[node2] = 2;
            }
        }

        return res == edges.length ? -1 : res;
    }
}
