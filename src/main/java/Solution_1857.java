package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1857 {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> matrix = IntStream.range(0, colors.length())
                .<List<Integer>>mapToObj(i -> new ArrayList<>())
                .collect(Collectors.toCollection(() -> new ArrayList<>(colors.length())));

        int[] inDegree = new int[colors.length()];

        for (int[] edge : edges) {
            if (edge[0] == edge[1]) return -1;
            List<Integer> key = matrix.get(edge[0]);
            key.add(edge[1]);
            matrix.set(edge[0], key);
            inDegree[edge[1]]++;
        }

        int[][] dp = new int[colors.length()][26];

        int maxValue = 0;

        Queue<Integer> q = IntStream.range(0, colors.length())
                .filter(i -> inDegree[i] == 0)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        int cnt = 0;

        while (!q.isEmpty()) {
            int curNode = q.poll();
            cnt++;
            dp[curNode][colors.charAt(curNode) - 'a']++;
            boolean flag = true;
            for (int k = 0; k < matrix.get(curNode).size(); k++) {
                int i = matrix.get(curNode).get(k);
                IntStream.range(0, 26).forEach(j -> dp[i][j] = Math.max(dp[i][j], dp[curNode][j]));
                flag = false;
                if (--inDegree[i] == 0) q.add(i);
            }
            if (flag)
                for (int x : dp[curNode]) maxValue = Math.max(maxValue, x);
        }
        if (cnt == colors.length()) return maxValue;

        return -1;
    }
}
